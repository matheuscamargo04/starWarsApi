package com.starWarsApis.starWarsApis.web.dto;

import org.springframework.http.HttpStatus;

public class ApiError {

	String data;
	HttpStatus status;

	public ApiError data(String data, HttpStatus status) {
		this.data = data;
		this.status = status;

		return this;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
