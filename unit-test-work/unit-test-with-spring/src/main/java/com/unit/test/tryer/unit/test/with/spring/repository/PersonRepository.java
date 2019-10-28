package com.unit.test.tryer.unit.test.with.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unit.test.tryer.unit.test.with.spring.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
