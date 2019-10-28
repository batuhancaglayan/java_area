package com.user.role.tryer.entity.wrapper;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.user.role.tryer.model.RoleScope;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@Entity(name = "role_permission")
public class RoleScopeWrapper extends RoleScope {
	
	private ScopeWrapper scope;
	
	private FunctionWrapper function;
	
	private RoleWrapper role;
	
	public RoleScopeWrapper(ScopeWrapper scope, FunctionWrapper function, RoleWrapper role) {
		super(scope.getCode(), function.getCode(), role.getId());
		this.scope = scope;
		this.function = function;
		this.role = role;
	}
	
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public long getId() {
		return super.getId();
	}
	
	@Transient
	@Override 
	public String getScopeCode() {
		return this.scope.getCode();
	}
	
	@Transient
	@Override 
	public String getFunctionCode() {
		return this.function.getCode();
	}
	
	@Transient
	@Override 
	public long getRoleId() {
		return this.role.getId();
	}
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	public ScopeWrapper getScope() {
		return scope;
	}

	public void setScope(ScopeWrapper scope) {
		this.scope = scope;
	}

	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	public FunctionWrapper getFunction() {
		return function;
	}

	public void setFunction(FunctionWrapper function) {
		this.function = function;
	}

	@NonNull
	@ManyToOne
	@JsonBackReference
	public RoleWrapper getRole() {
		return role;
	}

	public void setRole(RoleWrapper role) {
		this.role = role;
	}
}
