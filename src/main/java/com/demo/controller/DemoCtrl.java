package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCtrl {
	
	@GetMapping("/")
	public String greet(){
		return "Hello World !!";
	}
	
	@GetMapping("/me")
	public String greetMe(){
		return "Hello Sayan !!";
	}
}
