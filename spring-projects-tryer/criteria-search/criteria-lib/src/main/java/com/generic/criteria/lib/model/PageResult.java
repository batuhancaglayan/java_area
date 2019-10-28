package com.generic.criteria.lib.model;

import java.util.List;

import lombok.Data;

@Data
public class PageResult {
	
	private int pageNumber;
	
	private int itemPerPage;
	
	private int total;
	
	private List<?> data;
}
