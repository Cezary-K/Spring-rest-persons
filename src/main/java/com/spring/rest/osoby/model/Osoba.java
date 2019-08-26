package com.spring.rest.osoby.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "osoby")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Osoba implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "imie")
	private String imie;
	@Column(name = "wiek")
	private int wiek;
	@Column(name = "miasto")
	private String miasto;
	@Column(name = "pesel")
	private String pesel;

	public Osoba() {

	}

	public Osoba(int id, String imie, int wiek, String miasto, String pesel) {

		this.id = id;
		this.imie = imie;
		this.wiek = wiek;
		this.miasto = miasto;
		this.pesel = pesel;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

}
