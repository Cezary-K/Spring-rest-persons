package com.spring.rest.osoby.model.function;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.osoby.exception.OsobaExceptionID;
import com.spring.rest.osoby.model.Osoba;

@Service
public class OldestFunkcjaOsoby implements FunkcjaOsoby<Osoba> {

	@Override
	public Osoba oblicz(List<Osoba> osoby, int ilosc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNazwa() {
		return "oldest";
	}

	@Override
	public String getOpis() {
		return "zwraca najstarsza osobe z listy osob";
	}

	@Override
	public Osoba wykonaj(List<Osoba> osoby) {
		return osoby.stream().max((o1,o2)-> o1.getWiek()-o2.getWiek()).orElseThrow(()-> new OsobaExceptionID(-1));
	}

}
