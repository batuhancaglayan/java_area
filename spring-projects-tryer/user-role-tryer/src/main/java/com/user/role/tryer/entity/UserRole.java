package com.user.role.tryer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity(name = "user_role")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NonNull
	@ManyToOne
	private User user;

	@NonNull
	@ManyToOne // cascade = CascadeType.ALL
	//@JoinColumn(name = "role", referencedColumnName = "id")
	private Role role;
}
