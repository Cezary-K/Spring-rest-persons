package com.spring.rest.osoby.model.function;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.rest.osoby.model.Osoba;

@Service
public class GentsFunkcjaOsoby implements FunkcjaOsoby<List<Osoba>> {

	@Override
	public List<Osoba> oblicz(List<Osoba> osoby, int ilosc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNazwa() {

		return "gents";
	}

	@Override
	public String getOpis() {

		return "zwraca wszystkich mezczyzn z listy osob";
	}

	@Override
	public List<Osoba> wykonaj(List<Osoba> osoby) {

		return osoby.stream().filter(e -> !e.getImie().endsWith("a")).collect(Collectors.toList());
	}

}
