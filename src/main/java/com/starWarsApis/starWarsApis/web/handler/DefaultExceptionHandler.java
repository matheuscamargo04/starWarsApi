package com.starWarsApis.starWarsApis.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.starWarsApis.starWarsApis.exceptions.NotFoundException;
import com.starWarsApis.starWarsApis.web.dto.ApiError;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<Object> handleNotFound(NotFoundException ex) {
		LOG.warn("Notfound error");
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiError().data(ex.getMessage(), HttpStatus.NOT_FOUND));

	}

}
