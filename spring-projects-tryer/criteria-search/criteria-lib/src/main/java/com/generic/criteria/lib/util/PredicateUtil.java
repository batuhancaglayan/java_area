package com.generic.criteria.lib.util;

import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.generic.criteria.lib.model.SearchValue;

public class PredicateUtil<T> {

	public Predicate createPredicate(CriteriaBuilder criteriaBuilder, Root<T> root,
			Entry<String, SearchValue> queryItem) {

		String fieldName = queryItem.getKey();
		SearchValue searchValue = queryItem.getValue();
		Object value = searchValue.getSearchValue();
		Predicate predicate = null;

		switch (searchValue.getSearchOperator()) {
		case EQUALS:
			predicate = criteriaBuilder.equal(root.get(fieldName),
					this.createCastedValue(root.get(fieldName).getJavaType(), value));
			break;
		case LIKE:
			predicate = criteriaBuilder.like(root.get(fieldName), "%" + value.toString() + "%");
			break;
		default:
			break;
		}

		return predicate;
	}

	private Object createCastedValue(Class abc, Object value) {
		if (abc.isEnum()) {
			return Enum.valueOf(abc, value.toString());
		}

		// manage extra type logic in here like localdatetime to instant.

		return value;
	}
}
