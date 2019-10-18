package com.starWarsApis.starWarsApis.web.dto;

import java.util.List;

public class GetResponse {

	private List<String> characters;

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}

}
