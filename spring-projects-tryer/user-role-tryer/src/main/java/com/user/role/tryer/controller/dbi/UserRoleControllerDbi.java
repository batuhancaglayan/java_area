package com.user.role.tryer.controller.dbi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.user.role.tryer.dbi.dao.RoleScopeDao;
import com.user.role.tryer.dbi.dao.UserRoleDao;
import com.user.role.tryer.jdbi.connection.RDSConnection;
import com.user.role.tryer.model.RoleAssignObject;
import com.user.role.tryer.model.RoleScope;
import com.user.role.tryer.model.UserRole;

@RequestMapping("userroledbi")
@RestController
public class UserRoleControllerDbi {

	private UserRoleDao userRoleDao;

	private RoleScopeDao roleScopeDao;

	@PostConstruct
	private void init() {
		this.userRoleDao = RDSConnection.getInstance().onDemand(UserRoleDao.class);
		this.roleScopeDao = RDSConnection.getInstance().onDemand(RoleScopeDao.class);
	}

	@GetMapping("/claims/dbi")
	public List<String> getUsersAllClaim(@RequestParam("userid") long userid) {
		List<String> claims = new ArrayList<>();
		List<Long> roleIdList = this.userRoleDao.getUserRoleIdList(userid);

		for (List<Long> roleList : Lists.partition(roleIdList, 10)) {
			List<RoleScope> roleScopeList = this.roleScopeDao.getRoleScope(roleList);
			for (RoleScope roleScope : roleScopeList) {
				claims.add(roleScope.getScopeCode() + ":" + roleScope.getFunctionCode());
			}
		}

		return claims;
	}

	@RequestMapping("/dbi/assigne")
	@PostMapping
	public boolean assignRoleToUser(@RequestBody RoleAssignObject roleAssignObject) {
		
		List<UserRole> userRoleList = new ArrayList<>();
		long userId = roleAssignObject.getUserId();
		for (long roleId : roleAssignObject.getRoleIdList()) {
			userRoleList.add(new UserRole(1, userId, roleId));
		}
		
		this.userRoleDao.insertAll(userRoleList.iterator());
		
		return true;
	}
}
