package com.petproject.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Color {

	@JsonProperty(Type.White)
	WHITE, 
	@JsonProperty(Type.Brown)
	BROWN,
	@JsonProperty(Type.Black)
	BLACK;

	private interface Type {
		String White = "White";
		String Brown = "Brown";
		String Black = "Black";
	}

}
