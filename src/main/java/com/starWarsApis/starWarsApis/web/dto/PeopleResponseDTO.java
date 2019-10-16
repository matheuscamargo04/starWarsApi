package com.starWarsApis.starWarsApis.web.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class PeopleResponseDTO {

	private String name;
	private Long height;
	private String mass;
	private String hairColor;
	private String skinColor;
	private String eyeColor;
	private String birthYear;
	private String gender;
	private List<String> homeWorld;
	private List<String> species;
	private String url;

}
