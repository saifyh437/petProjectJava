package com.petproject.request;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.petproject.util.Color;

public class PetRequest {
	
	@NotBlank
	@Length(min=3,max=10)
	private String petName;
	
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
