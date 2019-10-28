package com.user.role.tryer.repository.wrapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.role.tryer.entity.wrapper.UserRoleWrapper;
import com.user.role.tryer.entity.wrapper.UserWrapper;

public interface UserRoleRepository extends JpaRepository<UserRoleWrapper, Long>{
	
	List<UserRoleWrapper> findByUser(UserWrapper user);
}
