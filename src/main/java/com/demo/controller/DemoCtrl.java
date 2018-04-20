package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.data.repository.PersonRepository;
import com.demo.node.entity.Person;

@RestController
public class DemoCtrl {
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/greet")
	public String greet(){
		return "Hello World !!";
	}
	
	@GetMapping("/greet-me")
	public String greetMe(){
		return "Hello Sayan !!";
	}
	
	@GetMapping("/name/{name}")
	public Person getByName(@PathVariable String name){
		return personRepository.findByName(name);
	}
}
