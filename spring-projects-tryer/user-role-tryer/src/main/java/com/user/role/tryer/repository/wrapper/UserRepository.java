package com.user.role.tryer.repository.wrapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.role.tryer.entity.wrapper.UserWrapper;

public interface UserRepository extends JpaRepository<UserWrapper, Long>{
}
