package com.user.registration.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.user.registration.system.entity.CandidateUserEntity;
import com.user.registration.system.entity.UserEntity;
import com.user.registration.system.model.CandidateUserModel;
import com.user.registration.system.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserModel toModel(UserEntity userEntity);

	CandidateUserModel toModel(CandidateUserEntity userEntity);
	
	CandidateUserEntity toEntity(CandidateUserModel userModel);

	@Mapping(target = "id", ignore = true)
	UserEntity toEntity(UserModel userModel);

	@Mapping(target = "id", ignore = true)
	CandidateUserEntity toCandidateEntity(UserModel userModel);
	
	@Mapping(target = "id", ignore = true)
	UserEntity toEntity(CandidateUserEntity userEntity);
}
