package com.unit.test.tryer.unit.test.wihtout.spring;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.unit.test.tryer.unit.test.wihtout.spring.service.DenemeRepository;
import com.unit.test.tryer.unit.test.wihtout.spring.service.DenemeService;

public class UnitTestTryer {

	@InjectMocks
	private DenemeService denemeService;

	@Mock
	public DenemeRepository denemeRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void denemeTest() {
		String key = "prefix";
		String expectedOutput = "deneme2121 " + key;
		Mockito.when(denemeService.deneme(key)).thenReturn(expectedOutput);
		String output = denemeService.deneme(key);
		assertThat(output, equalTo(expectedOutput));
		Mockito.verify(this.denemeRepository, times(1)).deneme(key);
	}
}
