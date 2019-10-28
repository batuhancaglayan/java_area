package com.user.role.tryer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RoleScope {
	
	private long id;
	
	@NonNull
	private String scopeCode;
	
	@NonNull
	private String functionCode;
	
	@NonNull
	private long roleId;
}
