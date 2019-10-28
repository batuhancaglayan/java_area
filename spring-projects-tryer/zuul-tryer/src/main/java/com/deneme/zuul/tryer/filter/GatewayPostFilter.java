package com.deneme.zuul.tryer.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.java.Log;

@Log
public class GatewayPostFilter extends ZuulFilter {

	public String filterType() {
		log.info("filterType GatewayPostFilter");
		return ZuulFilterType.POST.toString();
	}

	public int filterOrder() {
		return 999;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		log.info("GatewayPostFilter");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		if (response != null) {
			log.info(String.format("response t => ", response.getStatus()) + " => " + ctx.getResponseBody());
		}

		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}
}
