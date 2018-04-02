package com.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.node.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	public Person findByName(String name);
}
