package com.generic.criteria.lib.model;

import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class PageQuery {

	@Range(min = 0)
	private int pageNumber;

	@Range(min = 0)
	private int itemPerPage;

	@NotNull
	@NotEmpty
	Map<String, SearchValue> queryMap;
}
