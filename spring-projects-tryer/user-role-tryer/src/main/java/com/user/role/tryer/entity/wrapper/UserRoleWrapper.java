package com.user.role.tryer.entity.wrapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.user.role.tryer.model.UserRole;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity(name = "user_role")
public class UserRoleWrapper extends UserRole {

	private UserWrapper user;

	private RoleWrapper role;

	public UserRoleWrapper(UserWrapper user, RoleWrapper role) {
		this.user = user;
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
	public long getUserId() {
		return this.user.getId();
	}

	@Transient
	@Override
	public long getRoleId() {
		return this.role.getId();
	}

	@ManyToOne
	public UserWrapper getUser() {
		return user;
	}

	public void setUser(UserWrapper user) {
		this.user = user;
	}

	@ManyToOne
	public RoleWrapper getRole() {
		return role;
	}

	public void setRole(RoleWrapper role) {
		this.role = role;
	}
}
