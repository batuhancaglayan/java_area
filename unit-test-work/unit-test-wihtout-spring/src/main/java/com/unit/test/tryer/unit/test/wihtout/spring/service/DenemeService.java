package com.unit.test.tryer.unit.test.wihtout.spring.service;

public class DenemeService {

	public DenemeRepository denemeRepository;

	public DenemeService(DenemeRepository denemeRepository) {
		this.denemeRepository = denemeRepository;
	}

	public String deneme(String str) {
		return this.denemeRepository.deneme(str);
	}
}
