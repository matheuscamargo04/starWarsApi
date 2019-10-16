package com.starWarsApis.starWarsApis.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.starWarsApis.starWarsApis.web.dto.Error404Output;
import com.starWarsApis.starWarsApis.web.dto.Error500Output;

@ControllerAdvice
public class DefaultExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error500Output> genericException(Exception ex) {
		LOG.error("Generic error raised", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error500Output().data(ex.getMessage()));
	}

	@ExceptionHandler(NotFound.class)
	public ResponseEntity<Error404Output> notFoundException(NotFound ex) {
		LOG.error("Business error raised", ex);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error404Output().data(ex.getMessage()));
	}

}
