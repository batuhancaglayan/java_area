package com.user.role.tryer.repository.wrapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.role.tryer.entity.wrapper.RoleWrapper;

public interface RoleRepository extends JpaRepository<RoleWrapper, Long>{
}
