package com.starWarsApis.starWarsApis.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.starWarsApis.starWarsApis.web.dto.FilmResponseDTO;
import com.starWarsApis.starWarsApis.web.dto.PeopleResponseDTO;

@Service
public class JdtestService {

	@Autowired
	private RestTemplate rest;

	private Set<PeopleResponseDTO> getCharactersFromFilm(Long filmId) {

		String urlFilm = "https://swapi.co/api/films/" + filmId;
		FilmResponseDTO filmDTO = rest.getForObject(urlFilm, FilmResponseDTO.class);
		
		return filmDTO.getCharacters().stream().map(p -> rest.getForObject(p, PeopleResponseDTO.class)).collect(Collectors.toSet());
	}
	
	private String getSpecieFromCharacter(Long idCharacter) {
		
		String urlCharacter = "https://swapi.co/api/people/" + idCharacter;
		return rest.getForObject(urlCharacter, PeopleResponseDTO.class).getSpecies().get(0);
		
	}
	
	public List<String> getCharactersByTheSpecie(Long idFilm, Long idCharacter){
		
		String specie = getSpecieFromCharacter(idCharacter);
		
		Set<PeopleResponseDTO> charactersFromFilm = getCharactersFromFilm(idFilm);
		
		List<PeopleResponseDTO> peoples = charactersFromFilm.stream().filter(c -> c.getSpecies().get(0).equals(specie)).collect(Collectors.toList());
		
		return peoples.stream().map(PeopleResponseDTO::getName).collect(Collectors.toList());
	}

}
