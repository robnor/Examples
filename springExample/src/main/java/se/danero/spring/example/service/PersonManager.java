package se.danero.spring.example.service;

import java.util.List;

import se.danero.spring.example.model.Person;

public interface PersonManager {
	public void insertPersons(List<Person> persons);

	public List<Person> findAllPersons();
}
