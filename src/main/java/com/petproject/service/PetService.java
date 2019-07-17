package com.petproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petproject.model.Pet;
import com.petproject.repository.PetRepository;
import com.petproject.request.PetRequest;
import com.petproject.response.PetResponse;

@Service
public class PetService {

	private PetRepository petProjectRepository;

	@Autowired
	public PetService(PetRepository petProjectRepository) {
		this.petProjectRepository = petProjectRepository;
	}

	public List<PetResponse> findAllPets() {

		List<Pet> pets = (List<Pet>) petProjectRepository.findAll();

		List<PetResponse> petResponses = new ArrayList<PetResponse>();

		for (Pet pet : pets) {
			petResponses.add(mapPets(pet));
		}

		return petResponses;
	}

	private PetResponse mapPets(Pet pet) {
		PetResponse petResponse = new PetResponse();

		petResponse.setPetColor(pet.getPetColor());
		petResponse.setPetName(pet.getPetName());

		return petResponse;

	}

	public PetResponse createPet(PetRequest petRequest) {
		Pet pet = new Pet();
		

		pet.setPetColor(petRequest.getPetColor());
		pet.setPetName(petRequest.getPetName());
		
		PetResponse petResponse = mapPets(pet);
		petProjectRepository.save(pet);

		return petResponse;
	}

}
