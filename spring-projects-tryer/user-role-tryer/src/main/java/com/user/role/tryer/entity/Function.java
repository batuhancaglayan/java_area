package com.user.role.tryer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Entity(name = "function")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Function {

	@NonNull
	@Id
	private String code;
	
	private String displayName;
	
	@ManyToOne
	private Scope scope;
}
