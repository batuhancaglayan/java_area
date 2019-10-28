package com.javers.history.tryer.entity;

import org.javers.core.metamodel.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	
	@Id
    private String id;
	
    private String name;
}
