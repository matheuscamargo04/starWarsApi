package com.starWarsApis.starWarsApis.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starWarsApis.starWarsApis.exceptions.NotFoundException;
import com.starWarsApis.starWarsApis.service.JdtestService;
import com.starWarsApis.starWarsApis.web.dto.GetResponse;

@RestController
@RequestMapping("/api")
public class JdtestController {

	@Autowired
	private JdtestService service;

	@GetMapping(value = "/jdtest", produces = "application/json")
	public GetResponse getJdtest(@RequestParam(name = "film_id") Long filmId,
			@RequestParam(name = "character_id") Long characterId) throws NotFoundException, RuntimeException {

		List<String> charactersByTheSpecie = service.getCharactersByTheSpecie(filmId, characterId);

		GetResponse response = new GetResponse();
		response.setCharacters(charactersByTheSpecie);

		return response;

	}

}
