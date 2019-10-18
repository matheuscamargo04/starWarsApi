package com.starWarsApis.starWarsApis.web.dto;

import java.util.List;

public class PeopleResponseDTO {

	private String name;
	private List<String> species;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

}
