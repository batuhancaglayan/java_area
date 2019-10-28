package com.user.registration.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.registration.system.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
