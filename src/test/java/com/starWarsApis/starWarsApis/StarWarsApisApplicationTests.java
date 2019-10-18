package com.starWarsApis.starWarsApis;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;

import com.starWarsApis.starWarsApis.util.AbstractEndpointTest;

public class StarWarsApisApplicationTests extends AbstractEndpointTest {

	private static final String newHopeFilm = "1";
	private static final String lukeId = "1";

	private static final String expected = "{\"characters\":[\"Luke Skywalker\",\"Obi-Wan Kenobi\",\"Wilhuff Tarkin\",\"Leia Organa\",\"Biggs Darklighter\",\"Jek Tono Porkins\",\"Beru Whitesun lars\",\"Owen Lars\",\"Darth Vader\",\"Wedge Antilles\",\"Han Solo\",\"Raymus Antilles\"]}";

	@Test
	public void successfullyGet() throws Exception {
		this.mockMvc.perform(getRequest(newHopeFilm, lukeId)).andExpect(content().json(expected))
				.andExpect(status().isOk());
	}

	private RequestBuilder getRequest(String filmId, String characterId) {
		return get(String.format("/api/jdtest?film_id=%s&character_id=%s", filmId, characterId))
				.contentType(MediaType.APPLICATION_JSON);
	}

}
