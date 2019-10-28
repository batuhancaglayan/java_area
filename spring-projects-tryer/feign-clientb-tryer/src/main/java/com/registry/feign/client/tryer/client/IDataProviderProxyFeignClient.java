package com.registry.feign.client.tryer.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("dataproviderservice-yunus")
@RibbonClient("dataproviderservice-yunus")
public interface IDataProviderProxyFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/threat-summary/tree-based")
	Map<String, HashMap<String, Map<String, Map<String, Long>>>> getTreeBasedThreatSummary(
			@RequestHeader(value = "Authorization") String bearerToken, @RequestParam(value = "start") String startDate,
			@RequestParam(value = "end") String endDate);
}
