package com.spring.projects.tryer.service.registry.client;

import java.util.logging.Level;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.AmazonInfo;

import lombok.extern.java.Log;

@Log
@Primary
@Component
@Profile("aws")
public class RegistryInstanceInfo extends EurekaInstanceConfigBean {

	@Value("${server.port}")
	private int port;

	@Value("${eureka.instance.hostname}")
	private String hostname;

	@Value("${eureka.client.cwn-route53-registry:false}")
	private boolean isRoute53Register;

	public RegistryInstanceInfo(InetUtils inetUtils) {
		super(inetUtils);
	}
	
	@PostConstruct
	private void init() {
		log.info("init RegistryInstanceInfo isRoute53Register => " + isRoute53Register);
		AmazonInfo amazonInfo = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		this.setDataCenterInfo(amazonInfo);
	}

	public void refreshInfo() {
		log.log(Level.WARNING, "Checking datacenter info changes");

		AmazonInfo newInfo = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		if (!this.getDataCenterInfo().equals(newInfo)) {
			log.info("Updating datacenterInfo");
			((AmazonInfo) this.getDataCenterInfo()).setMetadata(newInfo.getMetadata());
		}
	}

	private AmazonInfo getAmazonInfo() {
		return (AmazonInfo) getDataCenterInfo();
	}

	@Override
	public String getHostname() {
		AmazonInfo info = getAmazonInfo();
		final String publicHostname = info.get(AmazonInfo.MetaDataKey.publicHostname);
		log.info("getHostname isRoute53Register => " + isRoute53Register + " hostname => " + hostname);
		return this.isRoute53Register ? this.hostname
				: this.isPreferIpAddress() ? info.get(AmazonInfo.MetaDataKey.localIpv4)
						: publicHostname == null ? info.get(AmazonInfo.MetaDataKey.localHostname) : publicHostname;
	}

	@Override
	public String getHostName(final boolean refresh) {
		return this.getHostname();
	}

	@Override
	public int getNonSecurePort() {
		return this.port;
	}

	@Override
	public String getHomePageUrl() {
		return super.getHomePageUrl();
	}

	@Override
	public String getStatusPageUrl() {
		String scheme = getSecurePortEnabled() ? "https" : "http";
		return scheme + "://" + this.getHostname() + ":" + this.port + getStatusPageUrlPath();
	}

	@Override
	public String getHealthCheckUrl() {
		String scheme = getSecurePortEnabled() ? "https" : "http";
		return scheme + "://" + this.getHostname() + ":" + this.port + getHealthCheckUrlPath();
	}
}
