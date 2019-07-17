package com.petproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.petproject.util.Color;

@Entity
@Table(name = "PET")
public class Pet {

	public Pet(Long id, String petName, Color petColor) {
		super();
		this.id = id;
		this.petName = petName;
		this.petColor = petColor;
	}

	public Pet() {
		
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "PET_NAME")
	@NotNull
	private String petName;
	
	@Column(name = "PET_COLOR")
	@Enumerated(EnumType.STRING)
	private Color petColor;

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Color getPetColor() {
		return petColor;
	}

	public void setPetColor(Color petColor) {
		this.petColor = petColor;
	}

}
