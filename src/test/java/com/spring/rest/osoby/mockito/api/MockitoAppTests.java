package com.spring.rest.osoby.mockito.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.rest.osoby.model.Osoba;
import com.spring.rest.osoby.repository.OsobaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MockitoAppTests {

	@MockBean
	private OsobaRepository repositoryOsoby;

	@Test
	public void shouldReturnAllOsoby() {
		Mockito.when(repositoryOsoby.findAll())
				.thenReturn(Stream.of(new Osoba(1, "Marek", 33, "Warszawa", "33115464453"),
						new Osoba(2, "Czarek", 32, "Krakow", "86112603344")).collect(Collectors.toList()));
		assertEquals(2, repositoryOsoby.findAll().size());
	}

	@Test
	public void shouldReturnOsobaById() {
		Osoba osoba = new Osoba(2, "Marek", 33, "Warszawa", "8611236648");
		Mockito.when(repositoryOsoby.findById(2)).thenReturn(Optional.of(osoba));
	}

	@Test
	public void shouldReturnNewOsoba() {
		Osoba newOsoba = new Osoba(1, "Marek", 33, "Warszawa", "33115464453");
		Mockito.when(repositoryOsoby.saveAndFlush(newOsoba)).thenReturn(newOsoba);

	}

}
