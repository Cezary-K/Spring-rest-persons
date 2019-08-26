package com.spring.rest.osoby.controller;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.osoby.exception.OsobaExceptionID;
import com.spring.rest.osoby.exception.OsobaExceptionMiasto;
import com.spring.rest.osoby.exception.OsobaExceptionNieznanaFunkcja;
import com.spring.rest.osoby.model.Osoba;
import com.spring.rest.osoby.model.function.FunkcjaOsoby;
import com.spring.rest.osoby.repository.OsobaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bazaOsob")
@AllArgsConstructor
public class OsobyController {

	private final OsobaRepository repository;
	private final Set<FunkcjaOsoby<?>> funkcjeOsoby;

	@GetMapping("/osoby")
	public List<Osoba> getOsoby() {
		return repository.findAll();
	}

	public Osoba addNewOsoba(@RequestBody Osoba nowaOsoba) {
		return repository.saveAndFlush(nowaOsoba);
	}

	@GetMapping("/")
	public ResponseEntity<List<Osoba>> getAll() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Osoba> getOsoba(@PathVariable("id") int id) {
		return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new OsobaExceptionID(id)), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Osoba> addOsoba(@RequestBody Osoba nowaOsoba) {
		Osoba saved = repository.saveAndFlush(nowaOsoba);
		return new ResponseEntity<Osoba>(saved, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOsoba(@PathVariable("id") int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			throw new OsobaExceptionID(id);
		}

	}

	@GetMapping("/miasto/{miasto}")
	public ResponseEntity<List<Osoba>> getOsobyByMiasto(@PathVariable("miasto") String miasto) {
		return ResponseEntity.ok(repository.findByMiasto(miasto));
	}

	@GetMapping("/pesel/{pesel}")
	public ResponseEntity<Osoba> getOsobaByPesel(@PathVariable("pesel") String pesel) {
		return repository.findByPesel(pesel).map(ResponseEntity::ok).orElseThrow(() -> new OsobaExceptionID(-1));

	}

	@GetMapping("/miasto/{miasto}/{funkcja}")
	public ResponseEntity<Object> getOsobaByMiastoAndFunkcja(@PathVariable("miasto") String miasto,
			@PathVariable("funkcja") String nazwaFunkcji) {
		List<Osoba> osobyMiasto = repository.findByMiasto(miasto);
		if (osobyMiasto.isEmpty()) {
			throw new OsobaExceptionMiasto(miasto);
		}

		FunkcjaOsoby<?> funkcja = funkcjeOsoby.stream().filter(f -> f.getNazwa().equals(nazwaFunkcji)).findFirst()
				.orElseThrow(() -> new OsobaExceptionNieznanaFunkcja(nazwaFunkcji));

		Object result = funkcja.wykonaj(osobyMiasto);
		return ResponseEntity.ok(result);

	}

	@GetMapping("/funkcja/{funkcja}")
	public ResponseEntity<Object> getOsobyByFunkcja(@PathVariable("funkcja") String nazwaFunkcji) {
		FunkcjaOsoby<?> funkcja = funkcjeOsoby.stream().filter(f -> f.getNazwa().equals(nazwaFunkcji)).findFirst()
				.orElseThrow(() -> new OsobaExceptionNieznanaFunkcja(nazwaFunkcji));

		Object result = funkcja.wykonaj(repository.findAll());
		return ResponseEntity.ok(result);
	}

	@GetMapping("/parametryzowana/{funkcja}")
	public ResponseEntity<Object> getOsobyPoWieku(@PathVariable("funkcja") String funkcja) {
		final String nowaFunkcja;
		String[] wpisane = funkcja.split("=");
		String[] param = wpisane[1].split(" ");
		int ilosc = Integer.parseInt(param[1]);
		nowaFunkcja = param[0];

		FunkcjaOsoby<?> funkcje = funkcjeOsoby.stream().filter(e -> e.getNazwa().equals(nowaFunkcja)).findFirst()
				.orElseThrow(() -> new OsobaExceptionNieznanaFunkcja(nowaFunkcja));

		Object result = funkcje.oblicz(repository.findAll(), ilosc);
		return ResponseEntity.ok(result);

	}

}
