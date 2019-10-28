package com.user.role.tryer.entity.wrapper;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.user.role.tryer.model.Scope;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "scope")
public class ScopeWrapper extends Scope {

	private Set<FunctionWrapper> functionList;

	public ScopeWrapper(String code) {
		super(code);
	}

	@Id
	@Override
	public String getCode() {
		return super.getCode();
	}

	@Override
	public String getDisplayName() {
		return super.getDisplayName();
	}
	
	@Override
	public String getCreatedBy() {
		return super.getCreatedBy();
	}
	
	@Override
	public long getCreatedAt() {
		return super.getCreatedAt();
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scopeWrapper")
	public Set<FunctionWrapper> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(Set<FunctionWrapper> functionList) {
		this.functionList = functionList;
	}
}
