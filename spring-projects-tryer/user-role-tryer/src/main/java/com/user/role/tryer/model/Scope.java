package com.user.role.tryer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Scope {

	@NonNull
	private String code;
	
	private String displayName;
	
	private long createdAt;
	
	private String createdBy;
}
