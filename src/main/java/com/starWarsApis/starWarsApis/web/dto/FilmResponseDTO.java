package com.starWarsApis.starWarsApis.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class FilmResponseDTO {

	private String title;
	private Long episode_id;
	private String director;
	private List<String> characters;
	private List<String> species;

}
