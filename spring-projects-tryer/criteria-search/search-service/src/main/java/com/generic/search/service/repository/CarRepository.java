package com.generic.search.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.generic.search.service.entity.CarEntity;

public interface CarRepository extends CrudRepository<CarEntity, Long>{
}
