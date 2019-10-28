package com.user.registration.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "candidate_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CandidateUserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Long identityNo;
	
	private String name;
	
	private String email;
}
