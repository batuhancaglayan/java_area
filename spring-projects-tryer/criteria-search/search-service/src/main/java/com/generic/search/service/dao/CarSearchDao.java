package com.generic.search.service.dao;

import org.springframework.stereotype.Component;

import com.generic.criteria.lib.dao.SearchDao;
import com.generic.search.service.entity.CarEntity;

@Component
public class CarSearchDao extends SearchDao<CarEntity>{
	
	public CarSearchDao() {
		super(CarEntity.class);
	}
}
