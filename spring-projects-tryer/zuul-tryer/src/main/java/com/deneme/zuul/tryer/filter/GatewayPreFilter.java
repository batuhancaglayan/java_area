package com.deneme.zuul.tryer.filter;

import com.netflix.zuul.ZuulFilter;

import java.net.URL;

import com.netflix.zuul.context.RequestContext;

import lombok.extern.java.Log;

@Log
public class GatewayPreFilter extends ZuulFilter {

	public String filterType() {
		log.info("filterType GatewayPreFilter");
		return ZuulFilterType.PRE.toString();
	}

	public int filterOrder() {
		return 6;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		log.info("GatewayPreFilter");
		try {
			URL host = RequestContext.getCurrentContext().getRouteHost();

		    log.info(String.format("route reguest to => " + host.toString()));
		}catch (Exception e) {
			log.info("exception => " + e.getMessage() + " " + e.getStackTrace().toString());
		}

	    return null;
	}
}
