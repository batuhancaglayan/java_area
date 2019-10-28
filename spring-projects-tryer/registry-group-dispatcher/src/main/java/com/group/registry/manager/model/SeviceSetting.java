package com.group.registry.manager.model;

import javax.annotation.PostConstruct;

import com.group.registry.manager.constant.AppConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeviceSetting {

	private Integer totalServiceLoad = 2;

	private Integer maxPerServiceLoad = 2;

	private Integer currentServiceLoad = 1;

	private String clientIdentifier;

	@PostConstruct
	private void init() {
		this.clientIdentifier = System.getProperty(AppConstant.DISCOVERYCLIENTIDENTIFIER);
	}

	public Integer getCurrentServiceLoad() {

		synchronized (this.currentServiceLoad) {
			if (this.maxPerServiceLoad > currentServiceLoad) {
				return currentServiceLoad;
			} else {
				log.error("maxPerServiceLoad => " + this.maxPerServiceLoad
						+ " smaller than currentServiceLoad => " + this.currentServiceLoad);
				return maxPerServiceLoad;
			}
		}
	}

//	public void setCurrentServiceLoad(Integer currentServiceLoad) {
//		synchronized (this.currentServiceLoad) {
//			this.currentServiceLoad = currentServiceLoad;
//		}
//	}

	public String getClientIdentifier() {
		return clientIdentifier;
	}

	public void manageServiceLoad(int upServiceCount) {
		synchronized (this.currentServiceLoad) {
			int newLoad = this.totalServiceLoad / upServiceCount;
			if (newLoad == this.currentServiceLoad) {
				//log.info("manageServiceLoad not changed.");
			} else {
				log.info("manageServiceLoad currentServiceLoad change from => " + this.currentServiceLoad + " to => "
						+ newLoad);
				this.currentServiceLoad = newLoad;
			}
		}
	}
}
