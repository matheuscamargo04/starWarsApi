package com.starWarsApis.starWarsApis.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class GetResponse {

	private List<String> characters;
	private List<String> urls;

}
