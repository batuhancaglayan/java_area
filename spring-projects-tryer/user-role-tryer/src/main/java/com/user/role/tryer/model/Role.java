package com.user.role.tryer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Role {
	
	@NonNull
	private long id;

	private String name;
	
	private String description;
	
	private long createdAt;
	
	private String createdBy;
}
