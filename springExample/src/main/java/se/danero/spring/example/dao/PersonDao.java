package se.danero.spring.example.dao;

import java.util.List;

import se.danero.spring.example.model.Person;

public interface PersonDao {
	public void saveOrUpdate(Person person);

	public void delete(Person person);

	public void find(int id);

	public List<Person> findAllPersons();
}
