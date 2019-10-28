package com.user.registration.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "user")
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class UserEntity {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Long identityNo;
	
	private String name;
	
	private String email;
}
