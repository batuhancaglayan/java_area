package com.group.registry.manager.config;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.group.registry.manager.constant.AppConstant;
import com.group.registry.manager.model.SeviceSetting;
import com.group.registry.manager.util.DiscoveryManager;
import com.netflix.appinfo.ApplicationInfoManager;

@Configuration
public class EurekaClientAppConfig {

	@Autowired
	private ApplicationInfoManager applicationInfoManager;

	@PostConstruct
	private void init() {
		Map<String, String> map = this.applicationInfoManager.getInfo().getMetadata();
		map.put(AppConstant.DISCOVERYCLIENTIDENTIFIER, System.getProperty(AppConstant.DISCOVERYCLIENTIDENTIFIER));
	}

	@Bean
	public SeviceSetting seviceSetting() {
		return new SeviceSetting();
	}
}
