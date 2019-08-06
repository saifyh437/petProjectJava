package com.petproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petproject.request.PersonRequest;
import com.petproject.response.PersonResponse;
import com.petproject.service.PersonService;

@RestController
@CrossOrigin(origins = "*")
public class PersonProjectController {

	private PersonService personService;
	
	@Autowired
	public PersonProjectController(PersonService personService)
	{
		this.personService = personService;
	}
	
	@GetMapping("/personproject/all")
	public List<PersonResponse> getAllPersons()
	{
		List<PersonResponse> allPersons = (List<PersonResponse>) personService.findAllPersons();

		return allPersons;
		
	}
	
	@GetMapping("/personproject")
	public List<PersonResponse> getPersonName(@RequestParam(required = true) String personName)
	{
		List<PersonResponse> allPersons = (List<PersonResponse>) personService.findPersonName(personName);

		return allPersons;
		
	}
	
	@PostMapping("/personproject")
	public PersonResponse createPerson(@RequestBody @Valid PersonRequest personRequest)
	{
		PersonResponse personResponse = personService.createPerson(personRequest);
		
		return personResponse;
	}
	
}
