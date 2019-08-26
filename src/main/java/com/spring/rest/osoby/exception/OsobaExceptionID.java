package com.spring.rest.osoby.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OsobaExceptionID extends RuntimeException {

	private final int id;

	public OsobaExceptionID(int id) {
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Osoba o id " + id + " nie istnieje";
	}

}
