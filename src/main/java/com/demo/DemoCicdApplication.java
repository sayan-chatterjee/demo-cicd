package com.demo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.data.repository.PersonRepository;
import com.demo.node.entity.Person;

@SpringBootApplication
public class DemoCicdApplication {
	
	private final static Logger log = LoggerFactory.getLogger(DemoCicdApplication.class);

	public static void main(String[] args) {
		log.info("Test commit");
		SpringApplication.run(DemoCicdApplication.class, args);
	}
	
	@Bean
	CommandLineRunner demo(PersonRepository personRepository) {
		return args -> {

			personRepository.deleteAll();

			Person greg = new Person("Abesh");
			Person roy = new Person("Sayan");
			Person craig = new Person("Sourav");
			Person bs = new Person("Biman");

			List<Person> team = Arrays.asList(greg, roy, craig, bs);

			log.info("Before linking up with Neo4j...");
			//System.out.println("Before linking up with Neo4j...");

			team.stream().forEach(
				person -> log.info("\t" + person.toString())
				/*person -> System.out.println("\t" + person.toString())*/
			);

			personRepository.save(greg);
			personRepository.save(roy);
			personRepository.save(craig);
			personRepository.save(bs);

			/*greg = personRepository.findByName(greg.getName());
			greg.follows(roy);
			personRepository.save(greg);*/

			roy = personRepository.findByName(roy.getName());
			roy.follows(bs);
			roy.follows(craig);
			roy.follows(greg);
			// We already know that roy works with greg
			personRepository.save(roy);
			
			/*craig = personRepository.findByName(craig.getName());
			craig.follows(roy);
			personRepository.save(craig);*/
			
			bs = personRepository.findByName(bs.getName());
			bs.follows(roy);
			personRepository.save(bs);

			// We already know craig works with roy and greg

			log.info("Lookup each person by name...");
			//System.out.println("Lookup each person by name...");
			log.info("\t" + personRepository.findByName("Sayan").toString());
			/*team.stream().forEach(
				person -> log.info("\t" + personRepository.findByName(person.getName()).toString())
				person -> System.out.println("\t" + personRepository.findByName(person.getName()).toString())
			);*/
		};
	}
}
