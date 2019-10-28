package com.unit.test.tryer.unit.test.with.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unit.test.tryer.unit.test.with.spring.entity.Person;
import com.unit.test.tryer.unit.test.with.spring.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public void save(Person person) {
		this.personRepository.save(person);
	}

	public Person findById(long id) {
		try {
			Optional<Person> result = this.personRepository.findById(id);
			return result.isPresent() ? result.get() : null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
