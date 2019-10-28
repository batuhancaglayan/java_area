package com.user.role.tryer.entity.wrapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.user.role.tryer.model.User;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity(name = "user")
public class UserWrapper extends User {

	public UserWrapper(long id) {
		this.setId(id);
	}
	
	public UserWrapper(long id, String name) {
		super(id, name);
	}
	
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public long getId() {
		return super.getId();
	}
}
