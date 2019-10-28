package com.deneme.zuul.tryer.filter;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.java.Log;

@Log
public class GatewayRouteFilter extends ZuulFilter {

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		log.info("GatewayRouteFilter");
		try {
			URL host = RequestContext.getCurrentContext().getRouteHost();

		    log.info(String.format("route reguest to => " + host.toString()));
		}catch (Exception e) {
			log.info("exception => " + e.getMessage());
		}

		return null;
	}

	@Override
	public String filterType() {
		log.info("filterType GatewayRouteFilter");
		return "route";
	}

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER - 100;
	}
}
