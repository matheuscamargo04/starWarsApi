package com.starWarsApis.starWarsApis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.starWarsApis.starWarsApis.domain.Endpoints;
import com.starWarsApis.starWarsApis.util.RestCallUtils;
import com.starWarsApis.starWarsApis.web.dto.FilmResponseDTO;
import com.starWarsApis.starWarsApis.web.dto.PeopleResponseDTO;

@Service
public class JdtestService {

	private FilmResponseDTO getSpeciesFromFilm(Long filmId) {

		return (FilmResponseDTO) RestCallService.call(RestCallUtils.composeUrl(filmId, Endpoints.FILM),
				FilmResponseDTO.class, Endpoints.FILM);

	}

	private String getSpecieFromCharacter(Long idCharacter) {

		PeopleResponseDTO peopleDTO = (PeopleResponseDTO) RestCallService.call(
				RestCallUtils.composeUrl(idCharacter, Endpoints.PEOPLE), PeopleResponseDTO.class, Endpoints.PEOPLE);

		return peopleDTO.getSpecies().get(0);

	}

	public List<String> getCharactersByTheSpecie(Long filmId, Long idCharacter) {

		String specie = getSpecieFromCharacter(idCharacter);

		FilmResponseDTO speciesFromFilm = getSpeciesFromFilm(filmId);

		List<PeopleResponseDTO> peoples = speciesFromFilm.getSpecies().stream().filter(p -> p.equals(specie))
				.collect(Collectors.toList());

		return peoples.stream().map(PeopleResponseDTO::getName).collect(Collectors.toList());
	}

}
