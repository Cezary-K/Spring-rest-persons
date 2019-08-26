package com.spring.rest.osoby.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.osoby.model.Osoba;

public interface OsobaRepository extends JpaRepository<Osoba, Integer>{

	List<Osoba> findByMiasto(String miasto);

	Optional<Osoba> findByPesel(String pesel);
}
