package com.user.role.tryer.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Entity(name = "scope")
@Data
@AllArgsConstructor
@RequiredArgsConstructor 
@NoArgsConstructor
public class Scope {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
	
	@Id
	@NonNull
	private String code;
	
	private String displayName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scope")
	private Set<Function> functionList;
}
