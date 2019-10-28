package com.user.role.tryer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.role.tryer.entity.wrapper.FunctionWrapper;
import com.user.role.tryer.entity.wrapper.RoleScopeWrapper;
import com.user.role.tryer.entity.wrapper.RoleWrapper;
import com.user.role.tryer.entity.wrapper.ScopeWrapper;
import com.user.role.tryer.entity.wrapper.UserRoleWrapper;
import com.user.role.tryer.entity.wrapper.UserWrapper;
import com.user.role.tryer.model.RoleAssignObject;
import com.user.role.tryer.repository.wrapper.UserRoleRepository;

@RequestMapping("userrole")
@RestController
public class UserRoleController {
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@GetMapping("/claims")
	public List<String> getUsersAllClaim(@RequestParam("userid") long userid){
		List<String> claims = new ArrayList<>();
		List<UserRoleWrapper> userRoleList = this.userRoleRepository.findByUser(new UserWrapper(userid));
		for (UserRoleWrapper userRole : userRoleList) {
			RoleWrapper role = userRole.getRole();
			for (RoleScopeWrapper roleScope : role.getRoleScopeList()) {
				ScopeWrapper scope = roleScope.getScope();
				FunctionWrapper function = roleScope.getFunction();
				
				claims.add(scope.getCode() + ":" + function.getCode());
			}
		}
		 
		 return claims;
	}
	
	
	@RequestMapping("/assigne")
	@PostMapping
	public boolean assignRoleToUser(@RequestBody RoleAssignObject roleAssignObject) {
		List<UserRoleWrapper> userRoleList = new ArrayList<>();
		UserWrapper user = new UserWrapper(roleAssignObject.getUserId());
		for (long roleId : roleAssignObject.getRoleIdList()) {
			userRoleList.add(new UserRoleWrapper(user, new RoleWrapper(roleId)));
		}
			
		this.userRoleRepository.saveAll(userRoleList);
		//this.userRoleRepository.save(new UserRole(new User(roleAssignObject.getUserId()), roleList));
		return true;
	}
}
