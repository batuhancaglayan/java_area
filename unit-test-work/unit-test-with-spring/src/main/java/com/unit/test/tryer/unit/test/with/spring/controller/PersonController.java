package com.unit.test.tryer.unit.test.with.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unit.test.tryer.unit.test.with.spring.entity.Person;
import com.unit.test.tryer.unit.test.with.spring.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/findById/{id}")
	public Person findById(@PathVariable("id") long id) {
		return this.personService.findById(id);
	}

	@PostMapping("/save")
	public void addPerson(@RequestBody Person person) {
		this.personService.save(person);
	}
}
