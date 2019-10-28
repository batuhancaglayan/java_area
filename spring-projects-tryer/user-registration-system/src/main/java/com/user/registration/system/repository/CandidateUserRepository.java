package com.user.registration.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.registration.system.entity.CandidateUserEntity;

public interface CandidateUserRepository extends JpaRepository<CandidateUserEntity, Long> {

	CandidateUserEntity findByEmail(String email);
}
