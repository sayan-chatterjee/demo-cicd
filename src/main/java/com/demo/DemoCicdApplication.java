package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCicdApplication {

	public static void main(String[] args) {
		System.out.println("Test commit");
		SpringApplication.run(DemoCicdApplication.class, args);
	}
}
