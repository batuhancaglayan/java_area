package com.unit.test.tryer.unit.test.wihtout.spring;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.unit.test.tryer.unit.test.wihtout.spring.service.DenemeRepository;
import com.unit.test.tryer.unit.test.wihtout.spring.service.DenemeService;

// run with integration-test goal for automate test with maven, like mvn clean install integration-test
@Category(IntegrationTest.class)
public class IntegrationTestTryer {

	private DenemeService denemeService;

	@Before
	public void init() {
		this.denemeService = new DenemeService(new DenemeRepository());
	}

	@Test
	public void denemeTest() {
		assertThat(this.denemeService.deneme("dale"), equalTo("deneme dale"));
		assertNotEquals(this.denemeService.deneme("dale11111"), "deneme dale");
	}
}
