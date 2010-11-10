package se.danero.spring.example.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.danero.spring.example.dao.PersonDao;
import se.danero.spring.example.model.Person;

@Service(value = "personManager")
public class PersonManagerImpl implements PersonManager {

	@Resource(name = "personDAO")
	private PersonDao personDAO = null;

	public PersonDao getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDao personDAO) {
		this.personDAO = personDAO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void insertPersons(List<Person> persons) {
		if (persons != null) {
			for (Person person : persons) {
				this.personDAO.saveOrUpdate(person);
			}
		}
	}

	public List<Person> findAllPersons() {
		return this.personDAO.findAllPersons();
	}
}
