package com.petproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petproject.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer>{

}
