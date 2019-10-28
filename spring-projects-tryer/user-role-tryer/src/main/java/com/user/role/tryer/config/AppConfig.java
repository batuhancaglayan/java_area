package com.user.role.tryer.config;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.role.tryer.entity.wrapper.FunctionWrapper;
import com.user.role.tryer.entity.wrapper.ScopeWrapper;
import com.user.role.tryer.entity.wrapper.UserWrapper;
import com.user.role.tryer.repository.wrapper.FunctionRepository;
import com.user.role.tryer.repository.wrapper.ScopeRepository;
//import com.user.role.tryer.repository.FunctionRepository;
//import com.user.role.tryer.repository.ScopeRepository;
//import com.user.role.tryer.repository.UserRepository;
import com.user.role.tryer.repository.wrapper.UserRepository;

@Configuration
public class AppConfig {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScopeRepository scopeRepository;

	@Autowired
	private FunctionRepository functionRepository;

	@PostConstruct
	private void init() {
		this.userRepository.save(new UserWrapper(1, "batuhan"));

		ScopeWrapper scope = new ScopeWrapper("S1");
		scope.setDisplayName("Scope 1");

		ScopeWrapper scopeEntity = this.scopeRepository.save(scope);

		Set<FunctionWrapper> functionList = new HashSet<>();
		functionList.add(new FunctionWrapper("F1", "Function 1", scopeEntity));
		functionList.add(new FunctionWrapper("F2", "Function 2", scopeEntity));

		scope.setFunctionList(functionList);

		// Scope scope = new Scope("S1", "Scope 1");
		this.functionRepository.saveAll(functionList);
	}

	@Bean
	@Primary
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.NONE);
		objectMapper.setVisibility(PropertyAccessor.GETTER, Visibility.ANY);
		objectMapper.setVisibility(PropertyAccessor.IS_GETTER, Visibility.ANY);

		return objectMapper;
	}
}
