package com.user.role.tryer.model;

import java.util.Set;

import lombok.Data;

@Data
public class RoleObject {
	
	private String roleName;
	
	private Set<ScopeFunctionObject> scopeFunctionList;
}
