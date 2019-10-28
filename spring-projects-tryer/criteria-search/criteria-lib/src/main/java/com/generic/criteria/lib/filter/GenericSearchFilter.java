package com.generic.criteria.lib.filter;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.generic.criteria.lib.SearchFilter;
import com.generic.criteria.lib.model.SearchValue;
import com.generic.criteria.lib.util.PredicateUtil;

public class GenericSearchFilter<T> implements SearchFilter<T> {

	private Map<String, SearchValue> queryMap;
	
	private PredicateUtil<T> predicateUtil;

	public GenericSearchFilter(Map<String, SearchValue> queryMap) {
		this.queryMap = queryMap;
		this.predicateUtil = new PredicateUtil<T>();
	}
	
	protected PredicateUtil<T> getPredicateUtil() {
		return predicateUtil;
	}

	@Override
	public Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root<T> root) {

		Predicate[] predicates = new Predicate[queryMap.size()];
		int i = 0;

		for (Entry<String, SearchValue> queryItem : queryMap.entrySet()) {
			// predicates[i] = (criteriaBuilder.equal(root.get(queryItem.getKey()), queryItem.getValue()));
			predicates[i] = this.predicateUtil.createPredicate(criteriaBuilder, root, queryItem);
			i++;
		}

		return criteriaBuilder.and(predicates);
	}
}
