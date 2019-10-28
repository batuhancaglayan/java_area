package com.generic.criteria.lib.model;

import com.generic.criteria.lib.search.type.SearchOperator;

import lombok.Data;

@Data
public class SearchValue {

	private String searchValue;
	
	private SearchOperator searchOperator;
}
