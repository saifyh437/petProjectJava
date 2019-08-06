package com.petproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petproject.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{
	
	@Query("select p from Person p where p.personName = :personName")
	List<Person> findAllPersonNames(@Param("personName") String personName);

}
