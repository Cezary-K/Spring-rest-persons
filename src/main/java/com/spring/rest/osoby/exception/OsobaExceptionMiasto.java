package com.spring.rest.osoby.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OsobaExceptionMiasto extends RuntimeException {
	private final String miasto;

	public OsobaExceptionMiasto(String miasto) {

		this.miasto = miasto;
	}

	@Override
	public String getMessage() {
		return "Brak osoba w miescie " + miasto;
	}

}
