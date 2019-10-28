package com.user.role.tryer.model;

import java.util.List;

import lombok.Data;

@Data
public class RoleAssignObject {

	private long userId;
	
	private List<Long> roleIdList;
}
