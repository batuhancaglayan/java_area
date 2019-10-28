package com.generic.criteria.lib.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.generic.criteria.lib.SearchFilter;
import com.generic.criteria.lib.filter.GenericPageSearchFilter;
import com.generic.criteria.lib.model.PageQuery;
import com.generic.criteria.lib.model.PageResult;

public abstract class SearchDao<T> {

	@Autowired
	private EntityManager entityManager;

	private Class<T> persistentClass;

	public SearchDao(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
//		this.persistentClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), SearchDao.class);
//		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
//				.getActualTypeArguments()[0];
	}

	public List<T> search(SearchFilter<T> searchFilter) {
		return this.createTypeQuery(searchFilter).getResultList();
	}

	public PageResult searchWihPage(SearchFilter<T> searchFilter) {

		GenericPageSearchFilter<T> genericPageSearchFilter = (GenericPageSearchFilter<T>) searchFilter;
		TypedQuery<T> query = this.createTypeQuery(searchFilter);
		PageResult pageResult = new PageResult();
		if (genericPageSearchFilter.isPageQuery()) {

			PageQuery pageQuery = genericPageSearchFilter.getPageQuery();
			int pageNumber = pageQuery.getPageNumber();
			int itemPerPage = pageQuery.getItemPerPage();

			query.setFirstResult((pageNumber - 1) * itemPerPage);
			query.setMaxResults(itemPerPage);

			pageResult.setPageNumber(pageNumber);
			pageResult.setItemPerPage(itemPerPage);
			pageResult.setTotal(entityManager.createQuery(this.createCountQuery()).getSingleResult().intValue());
		}

		pageResult.setData(query.getResultList());
		return pageResult;
	}

	protected TypedQuery<T> createTypeQuery(SearchFilter<T> searchFilter) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
		Root<T> entityRoot = criteriaQuery.from(persistentClass);
		criteriaQuery.select(entityRoot);
		criteriaQuery.where(searchFilter.buildPredicate(criteriaBuilder, entityRoot));
		
		return entityManager.createQuery(criteriaQuery);
	}

	protected CriteriaQuery<Long> createCountQuery() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		countQuery.select(criteriaBuilder.count(countQuery.from(persistentClass)));
		return countQuery;
	}
}
