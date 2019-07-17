package com.petproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petproject.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

}
