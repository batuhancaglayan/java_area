package com.user.registration.system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.system.entity.CandidateUserEntity;
import com.user.registration.system.entity.UserEntity;
import com.user.registration.system.exception.NoCandidateUserFoundException;
import com.user.registration.system.exception.NoValidUserIdentityException;
import com.user.registration.system.exception.RegisterdUserAllreadyExistException;
import com.user.registration.system.exception.ServiceCallTimeOutException;
import com.user.registration.system.mapper.UserMapper;
import com.user.registration.system.model.CandidateUserModel;
import com.user.registration.system.model.UserModel;
import com.user.registration.system.repository.CandidateUserRepository;
import com.user.registration.system.repository.UserRepository;
import com.user.registration.system.util.IdentityService;
import com.user.registration.system.util.MailServiceUtil;

// sınıf aday kullanıcıyı alıp sistemde candidate_user tablosuna kaydeder (registerUser method) 
// ve kullanıya MailServiceUtil
@Service
public class UserService {

	@Autowired
	private CandidateUserRepository candidateUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private MailServiceUtil mailServiceUtil;

	@Autowired
	private UserMapper userMapper;

	public CandidateUserModel registerUser(CandidateUserModel userModel)
			throws RegisterdUserAllreadyExistException, ServiceCallTimeOutException, NoValidUserIdentityException {

		if (!this.identityService.isIdentitfNoValid(userModel.getIdentityNo())) {
			throw new NoValidUserIdentityException("user identity no is not valid for => " + userModel.getIdentityNo());
		}

		CandidateUserEntity candidateUser = this.candidateUserRepository.findByEmail(userModel.getEmail());
		if (candidateUser != null) {
			throw new RegisterdUserAllreadyExistException("User with email " + userModel.getEmail());
		}

		CandidateUserEntity dbCandidateUser = this.candidateUserRepository.saveAndFlush(this.userMapper.toEntity(userModel));
		this.mailServiceUtil.sendActivationMail(dbCandidateUser.getEmail(), dbCandidateUser.getId());

		return this.userMapper.toModel(dbCandidateUser);
	}

	public UserModel activateUser(Long id) throws NoCandidateUserFoundException {
		Optional<CandidateUserEntity> candidateUser = this.candidateUserRepository.findById(id);
		if (!candidateUser.isPresent()) {
			throw new NoCandidateUserFoundException("There is no candidate user with id " + id);
		}

		UserEntity userEntity = this.userMapper.toEntity(candidateUser.get());
		UserEntity dbUserEntity = this.userRepository.saveAndFlush(userEntity);
		this.candidateUserRepository.delete(candidateUser.get());
		this.mailServiceUtil.sendNotifyMail(dbUserEntity.getEmail(), dbUserEntity.getId());

		return this.userMapper.toModel(dbUserEntity);
	}
}
