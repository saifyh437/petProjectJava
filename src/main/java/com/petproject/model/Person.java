package com.petproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PERSON")
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "PERSON_NAME")
	@NotNull
	private String personName;
	
	@Column(name = "PERSON_AGE")
	private Integer personAge;

	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getPersonAge() {
		return personAge;
	}

	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}

}
