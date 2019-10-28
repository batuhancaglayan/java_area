package com.user.registration.system;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.registration.system.entity.CandidateUserEntity;
import com.user.registration.system.exception.NoValidUserIdentityException;
import com.user.registration.system.exception.RegisterdUserAllreadyExistException;
import com.user.registration.system.exception.ServiceCallTimeOutException;
import com.user.registration.system.mapper.UserMapper;
import com.user.registration.system.model.CandidateUserModel;
import com.user.registration.system.repository.CandidateUserRepository;
import com.user.registration.system.repository.UserRepository;
import com.user.registration.system.service.UserService;
import com.user.registration.system.util.IdentityService;
import com.user.registration.system.util.MailServiceUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "mock.timeout=6000" })
public class UserRegisterTest {

	@Autowired
	private UserService userService;

	@MockBean
	private CandidateUserRepository candidateUserRepository;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private IdentityService identityService;

	@MockBean
	private MailServiceUtil mailServiceUtil;

	@Autowired
	private UserMapper userMapper;

//	@Retention(RetentionPolicy.RUNTIME)
//	@Target(ElementType.TYPE)
//	@TestPropertySource(locations="classpath:test.properties")
//	public @interface DefaultTestAnnotations { }

	@Test
	public void registerUserTest()
			throws RegisterdUserAllreadyExistException, ServiceCallTimeOutException, NoValidUserIdentityException {

		CandidateUserModel cu = new CandidateUserModel(123456L, "batuhan", "batuhan@gmail.com");
		CandidateUserEntity cue = new CandidateUserEntity(654321L, 123456L, "batuhan", "batuhan@gmail.com");

		Mockito.when(this.identityService.isIdentitfNoValid(cu.getIdentityNo())).thenReturn(true);
		Mockito.when(this.candidateUserRepository.saveAndFlush(Mockito.any(CandidateUserEntity.class))).thenReturn(cue);
		Mockito.when(this.mailServiceUtil.sendActivationMail(cu.getEmail(), Mockito.anyLong())).thenReturn(true);
		
		CandidateUserModel cuSaved = this.userService.registerUser(cu);

		verify(this.identityService, times(1)).isIdentitfNoValid(cu.getIdentityNo());
		verify(this.mailServiceUtil, times(1)).sendActivationMail(cu.getEmail(), Mockito.any());

		assertNotNull(cuSaved);
		assertThat(cuSaved, equalTo(cue));
	}
}
