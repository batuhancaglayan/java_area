package com.generic.search.service.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generic.criteria.lib.dao.SearchDao;
import com.generic.criteria.lib.filter.GenericSearchFilter;
import com.generic.criteria.lib.model.SearchValue;
import com.generic.search.service.entity.UserEntity;
import com.generic.search.service.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	@Qualifier("userSearchDao")
	private SearchDao<UserEntity> userSearchDao;

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public Iterable<UserEntity> getAllUsers() {
		return this.userRepository.findAll();
	}

	@GetMapping("/search")
	public List<UserEntity> search(@RequestBody Map<String, SearchValue> queryMap) {
		return this.userSearchDao.search(new GenericSearchFilter<UserEntity>(queryMap));
	}

	@PostMapping("/add")
	public UserEntity add(@Valid @RequestBody UserEntity user) {
		return this.userRepository.save(user);
	}
}
