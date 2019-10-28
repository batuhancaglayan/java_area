package com.user.role.tryer.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Entity(name = "role_scope")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RoleScope {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Scope scope;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Function function;
	
	@NonNull
	@ManyToOne
	@JsonBackReference
	private Role role;
}
