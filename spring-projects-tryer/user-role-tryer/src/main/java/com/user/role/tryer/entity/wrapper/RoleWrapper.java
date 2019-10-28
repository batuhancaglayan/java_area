package com.user.role.tryer.entity.wrapper;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.user.role.tryer.model.Role;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@Entity(name = "role")
public class RoleWrapper extends Role {

	private Set<RoleScopeWrapper> roleScopeList;
	
	public RoleWrapper(long roleId) {
		super(roleId);
	}
	
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public long getId() {
		return super.getId();
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public String getDescription() {
		return super.getDescription();
	}
	
	@Override
	public String getCreatedBy() {
		return super.getCreatedBy();
	}
	
	@Override
	public long getCreatedAt() {
		return super.getCreatedAt();
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	@JsonManagedReference
	public Set<RoleScopeWrapper> getRoleScopeList() {
		return roleScopeList;
	}

	public void setRoleScopeList(Set<RoleScopeWrapper> roleScopeList) {
		this.roleScopeList = roleScopeList;
	}
}
