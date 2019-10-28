package com.user.role.tryer.entity.wrapper;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.user.role.tryer.model.Function;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity
@Table(name = "permission")
public class FunctionWrapper extends Function {
	
	private ScopeWrapper scopeWrapper;
	
	public FunctionWrapper(String code) {
		this.setCode(code);
	}
	
	public FunctionWrapper(String code, String displayName, ScopeWrapper scope) {
		super(code, displayName, scope.getCode());
		this.scopeWrapper = scope;
	}

	@NonNull
	@Id
	@Override
	public String getCode() {
		return super.getCode();
	}
	
	@Override 
	public String getDisplayName() {
		return super.getDisplayName();
	}
	
	@Transient
	@Override 
	public String getScopeCode() {
		return this.scopeWrapper.getCode();
	}
	
	@JoinColumn(name = "scope_code")
	@ManyToOne(targetEntity = ScopeWrapper.class)
	public ScopeWrapper getScopeWrapper() {
		return this.scopeWrapper;
	}
	
	public void setScopeWrapper(ScopeWrapper scopeWrapper) {
		this.scopeWrapper = scopeWrapper;
	}
}
