package se.danero.spring.example.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import se.danero.spring.example.model.Person;

@Service(value = "personDAO")
public class HibernatePersonDao extends HibernateDaoSupport implements PersonDao {

	@Autowired
	public HibernatePersonDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	public void saveOrUpdate(Person person) {
		this.getHibernateTemplate().saveOrUpdate(person);
	}

	public void delete(Person person) {
		this.getHibernateTemplate().delete(person);
	}

	public void find(int id) {
		this.getHibernateTemplate().load(Person.class, id);
	}

	public List<Person> findAllPersons() {
		return this.getHibernateTemplate().find("from Person");
	}

}
