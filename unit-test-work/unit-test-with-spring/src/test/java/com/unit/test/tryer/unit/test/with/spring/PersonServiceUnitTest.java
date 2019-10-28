package com.unit.test.tryer.unit.test.with.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.unit.test.tryer.unit.test.with.spring.entity.Person;
import com.unit.test.tryer.unit.test.with.spring.repository.PersonRepository;
import com.unit.test.tryer.unit.test.with.spring.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceUnitTest {

	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	private long id = 1;

//	@TestConfiguration
//	static class EmployeeServiceImplTestContextConfiguration {
//
//		@Bean
//		public PersonService employeeService() {
//			return new PersonService();
//		}
//	}

	@Before
	public void before() {
		Mockito.when(personRepository.findById(this.id)).thenReturn(Optional.of(new Person(id)));
	}

	@Test
	public void testFindById() {

		Person p = this.personService.findById(1);
		assertThat(p.getId()).isEqualTo(this.id);
		verify(this.personRepository, times(1)).findById(id);
	}
}
