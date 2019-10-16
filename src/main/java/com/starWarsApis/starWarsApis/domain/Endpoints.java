package com.starWarsApis.starWarsApis.domain;

public enum Endpoints {

	FILM("https://swapi.co/api/films/"), SPECIES("https://swapi.co/api/species/"), PEOPLE(
			"https://swapi.co/api/people/");

	String url;

	private Endpoints(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
