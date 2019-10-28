package com.object.oriented.design.logistic.system.design.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
	
	private UUID id = UUID.randomUUID();
	 
	private @NonNull String name;

	private @NonNull Location location;
}
