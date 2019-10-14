package com.starWarsApis.starWarsApis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.starWarsApis.starWarsApis.service.JdtestService;
import com.starWarsApis.starWarsApis.web.dto.FilmResponseDTO;
import com.starWarsApis.starWarsApis.web.dto.GetResponse;
import com.starWarsApis.starWarsApis.web.dto.PeopleResponseDTO;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private RestTemplate rest;

	@Autowired
	private JdtestService service;

	@GetMapping(value = "/jdtest", produces = "application/json")
	public GetResponse getJdtest(@RequestParam(name = "film_id") Long filmId,
			@RequestParam(name = "character_id") Long characterId) {

		String urlFilm = "https://swapi.co/api/films/" + filmId.toString();
		String urlPeople = "https://swapi.com/api/people/" + characterId.toString();

		FilmResponseDTO filmResponseDTO = rest.getForObject(urlFilm, FilmResponseDTO.class);
		PeopleResponseDTO peopleResponseDTO = rest.getForObject(urlPeople, PeopleResponseDTO.class);

		return null;

	}

}
