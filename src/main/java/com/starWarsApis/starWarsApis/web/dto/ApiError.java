package com.starWarsApis.starWarsApis.web.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiError {

	String data;
	HttpStatus status;

	public ApiError data(String data, HttpStatus status) {
		this.data = data;
		this.status = status;

		return this;
	}

}
