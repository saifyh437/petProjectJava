package com.petproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petproject.request.PetRequest;
import com.petproject.response.PetResponse;
import com.petproject.service.PetService;

@RestController
@CrossOrigin(origins = "*")
public class PetProjectController {
	
	private PetService petService;

	@Autowired
	public PetProjectController(PetService petService)
	{
		this.petService = petService;
	}


	@GetMapping("/petproject")
	public List<PetResponse> getAllPets() 
	{
		List<PetResponse> allPets = (List<PetResponse>) petService.findAllPets();

		return allPets;
	}
	
	@PostMapping("/petproject")
	public PetResponse createPet(@RequestBody @Valid PetRequest petRequest)
	{
		PetResponse petResponse = petService.createPet(petRequest);
		
		return petResponse;
	}

}
