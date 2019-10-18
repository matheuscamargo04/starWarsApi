package com.starWarsApis.starWarsApis.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.starWarsApis.starWarsApis.domain.Endpoints;
import com.starWarsApis.starWarsApis.util.RestCallUtils;
import com.starWarsApis.starWarsApis.web.dto.FilmResponseDTO;
import com.starWarsApis.starWarsApis.web.dto.PeopleResponseDTO;

@Service
public class JdtestService {

	private Set<PeopleResponseDTO> getCharactersFromFilm(Long filmId) {

		FilmResponseDTO filmDTO = (FilmResponseDTO) RestCallService
				.call(RestCallUtils.composeUrl(filmId, Endpoints.FILM), FilmResponseDTO.class, Endpoints.FILM);

		return filmDTO.getCharacters().stream()
				.map(p -> (PeopleResponseDTO) RestCallService.call(p, PeopleResponseDTO.class, Endpoints.PEOPLE))
				.collect(Collectors.toSet());
	}

	private String getSpecieFromCharacter(Long idCharacter) {

		PeopleResponseDTO peopleDTO = (PeopleResponseDTO) RestCallService.call(
				RestCallUtils.composeUrl(idCharacter, Endpoints.PEOPLE), PeopleResponseDTO.class, Endpoints.PEOPLE);

		return peopleDTO.getSpecies().get(0);

	}

	public List<String> getCharactersByTheSpecie(Long idFilm, Long idCharacter) {

		String specie = getSpecieFromCharacter(idCharacter);

		Set<PeopleResponseDTO> charactersFromFilm = getCharactersFromFilm(idFilm);

		List<PeopleResponseDTO> peoples = charactersFromFilm.stream().filter(c -> c.getSpecies().get(0).equals(specie))
				.collect(Collectors.toList());

		return peoples.stream().map(PeopleResponseDTO::getName).collect(Collectors.toList());
	}

}
