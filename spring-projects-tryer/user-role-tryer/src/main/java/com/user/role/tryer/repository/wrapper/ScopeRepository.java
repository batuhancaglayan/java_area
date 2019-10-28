package com.user.role.tryer.repository.wrapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.role.tryer.entity.wrapper.ScopeWrapper;

public interface ScopeRepository extends JpaRepository<ScopeWrapper, String>{
}
