package com.petproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petproject.model.Person;
import com.petproject.repository.PersonRepository;
import com.petproject.request.PersonRequest;
import com.petproject.response.PersonResponse;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<PersonResponse> findAllPersons() {

		List<Person> persons = (List<Person>) personRepository.findAll();

		List<PersonResponse> personResponses = new ArrayList<PersonResponse>();

		for (Person person : persons) {
			personResponses.add(mapPersons(person));
		}

		return personResponses;
	}

	private PersonResponse mapPersons(Person person) {
		PersonResponse personResponse = new PersonResponse();

		personResponse.setPersonAge(person.getPersonAge());
		personResponse.setPersonName(person.getPersonName());

		return personResponse;
	}

	public PersonResponse createPerson(PersonRequest personRequest) {
		Person person = new Person();
		

		person.setPersonAge(personRequest.getPersonAge());
		person.setPersonName(personRequest.getPersonName());
		
		PersonResponse petResponse = mapPersons(person);
		personRepository.save(person);

		return petResponse;
	}
	
	

}
