package com.petproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.petproject.repository.PersonRepository;
import com.petproject.service.PersonService;

@SpringBootApplication
@Configuration
public class PersonProjectControllerTestConfiguration {
	
	@Bean
	public PersonService personService(PersonRepository personRepository) {
		return new PersonService(personRepository);
	}

}
