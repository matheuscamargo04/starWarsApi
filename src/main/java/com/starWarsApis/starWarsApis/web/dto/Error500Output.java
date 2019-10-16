package com.starWarsApis.starWarsApis.web.dto;

public class Error500Output {

	public Error500Output data(String data) {
		this.data = data;
		return this;
	}

	String data;

}
