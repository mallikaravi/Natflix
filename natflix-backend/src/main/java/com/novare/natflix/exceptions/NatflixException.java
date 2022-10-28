package com.novare.natflix.exceptions;

import org.springframework.http.HttpStatus;

public class NatflixException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;

	public NatflixException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public NatflixException(String message, HttpStatus status, String message1) {
		super(message);
		this.status = status;
		this.message = message1;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}
}