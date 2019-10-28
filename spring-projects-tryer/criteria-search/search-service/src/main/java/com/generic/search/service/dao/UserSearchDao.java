package com.generic.search.service.dao;

import org.springframework.stereotype.Component;

import com.generic.criteria.lib.dao.SearchDao;
import com.generic.search.service.entity.UserEntity;

@Component
public class UserSearchDao extends SearchDao<UserEntity> {
	
	public UserSearchDao() {
		super(UserEntity.class);
	}
}
