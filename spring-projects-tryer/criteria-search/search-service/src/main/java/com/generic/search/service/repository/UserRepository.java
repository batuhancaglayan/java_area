package com.generic.search.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.generic.search.service.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
}
