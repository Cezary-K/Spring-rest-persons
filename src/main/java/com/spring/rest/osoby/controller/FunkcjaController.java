package com.spring.rest.osoby.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.osoby.model.function.FunkcjaOsoby;

import lombok.AllArgsConstructor;

//..
@RestController
@RequestMapping("/funkcje")
@AllArgsConstructor
public class FunkcjaController {

	private final Set<FunkcjaOsoby<?>> funkcjeOsoby;
	
	@GetMapping("/osoba")
	public ResponseEntity<List<FunkcjaOsoby<?>>> getFunkcjeOsoby() {
		return ResponseEntity.ok(funkcjeOsoby.stream().collect(Collectors.toList()));
	}

}
