package com.generic.criteria.lib.filter;

import com.generic.criteria.lib.model.PageQuery;

import lombok.Getter;

@Getter
public class GenericPageSearchFilter<T> extends GenericSearchFilter<T>{

	private PageQuery pageQuery;
	
	public GenericPageSearchFilter(PageQuery pageQuery) {
		super(pageQuery.getQueryMap());
		this.pageQuery = pageQuery;
	}

	public boolean isPageQuery() {		
		return pageQuery.getPageNumber() > 0 && pageQuery.getItemPerPage() > 0 ? true : false;
	}
}
