package com.petproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petproject.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer>{
	
	@Query("select p from Pet p where p.petName = :petName")
	List<Pet> findPetNames(@Param("petName") String petName);

}
