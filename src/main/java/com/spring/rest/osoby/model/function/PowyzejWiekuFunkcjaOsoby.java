package com.spring.rest.osoby.model.function;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.rest.osoby.model.Osoba;

@Service
public class PowyzejWiekuFunkcjaOsoby implements FunkcjaOsoby<List<Osoba>> {

	@Override
	public String getNazwa() {

		return "gt";
	}

	@Override
	public String getOpis() {

		return "Wykaz osob starszych od podanego paramteru";
	}

	@Override
	public List<Osoba> wykonaj(List<Osoba> osoby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Osoba> oblicz(List<Osoba> osoby, int ilosc) {

		return osoby.stream().filter(e -> e.getWiek() > ilosc).collect(Collectors.toList());
	}

}
