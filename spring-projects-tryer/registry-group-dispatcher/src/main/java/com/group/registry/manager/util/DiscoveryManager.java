package com.group.registry.manager.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group.registry.manager.constant.AppConstant;
import com.group.registry.manager.model.SeviceSetting;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DiscoveryManager {

	@Autowired
	private SeviceSetting seviceSetting;
	
	@Autowired
	private EurekaClient discoveryClient;
	
	public void checkPeers() {
		Application application = this.discoveryClient.getApplication(AppConstant.GROUPCLIENT);
		int upServiceCount = 0;
		boolean currentAppDetected = false;
		if (application != null) {
			List<InstanceInfo> instanceList = application.getInstances();
			log.info("Instance count => " + instanceList.size());
			for (InstanceInfo instanceInfo : instanceList) {
				Map<String, String> metaMap = instanceInfo.getMetadata();
				if (!metaMap.containsKey(AppConstant.DISCOVERYCLIENTIDENTIFIER)) {
					continue;
				}
				
				String clientIdentifier = metaMap.get(AppConstant.DISCOVERYCLIENTIDENTIFIER);
				if (clientIdentifier.equals(seviceSetting.getClientIdentifier())) {
					currentAppDetected = true;
					continue;
				}
				
				if (instanceInfo.getStatus().equals(InstanceStatus.UP)) {
					upServiceCount = upServiceCount + 1;
				}
			}
			
			if (currentAppDetected) {
				upServiceCount = upServiceCount + 1;
			}
			
			log.info("upServiceCount => " + upServiceCount);
			this.seviceSetting.manageServiceLoad(upServiceCount);
		}
	}
}
