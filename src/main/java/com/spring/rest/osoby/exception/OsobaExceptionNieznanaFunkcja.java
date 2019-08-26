package com.spring.rest.osoby.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OsobaExceptionNieznanaFunkcja extends RuntimeException {
	private final String funkcja;

	public OsobaExceptionNieznanaFunkcja(String funkcja) {

		this.funkcja = funkcja;
	}

	@Override
	public String toString() {
		return "Funkcja : " + funkcja + " nie istnieje";
	}
}
