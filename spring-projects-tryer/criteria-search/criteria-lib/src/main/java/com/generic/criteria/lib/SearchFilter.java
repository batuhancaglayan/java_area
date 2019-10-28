package com.generic.criteria.lib;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface SearchFilter<T> {

	Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root<T> root);
}
