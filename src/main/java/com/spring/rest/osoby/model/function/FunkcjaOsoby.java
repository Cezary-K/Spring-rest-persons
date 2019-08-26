package com.spring.rest.osoby.model.function;

import java.util.List;

import com.spring.rest.osoby.model.Osoba;

public interface FunkcjaOsoby<T> {

	String getNazwa();

	String getOpis();

	T wykonaj(List<Osoba> osoby);

	T oblicz(List<Osoba> osoby, int ilosc);
}
