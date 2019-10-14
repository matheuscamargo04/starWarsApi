package com.starWarsApis.starWarsApis.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class PeopleResponseDTO {

	private String name;
	private Long height;
	private Long mass;
	private String hairColor;
	private String skinColor;
	private String eyeColor;
	private String birthYear;
	private String gender;
	private List<String> homeWorld;
	private List<String> species;

}
