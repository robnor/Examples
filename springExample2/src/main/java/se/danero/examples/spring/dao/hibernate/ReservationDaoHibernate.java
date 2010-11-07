package se.danero.examples.spring.dao.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import se.danero.examples.spring.dao.ReservationDao;
import se.danero.examples.spring.model.Reservation;
import se.danero.examples.spring.model.Reserver;
import se.danero.examples.spring.model.Resource;

public class ReservationDaoHibernate extends HibernateDaoSupport implements ReservationDao {

   @Autowired
	public void storeReservation(Reservation reservation) {
		getHibernateTemplate().saveOrUpdate(reservation);		
	}

	public Reservation findReservationById(Long id) {
		return (Reservation) getHibernateTemplate().get(Reservation.class, id);
	}

	
	private <T> List<T> convertToGenericList(@SuppressWarnings("rawtypes") List list) {
		System.out.println("List class: " + list.getClass());
		if (list.get(0).getClass() == Reservation.class) {
			@SuppressWarnings("unchecked")
			List<T> retval = (List<T>) list;
			return retval;
			
		}
		else {
			throw new ClassCastException();
		}
	}
	
	public List<Reservation> listReservations() {
		return convertToGenericList(getHibernateTemplate().find("from Reservation"));
	}

	public void deleteReservation(int id) {
		Reservation reservation = getHibernateTemplate().load(Reservation.class, id);
		deleteReservation(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		getHibernateTemplate().delete(reservation);		
	}

	public void storeResource(Resource resource) {
		getHibernateTemplate().saveOrUpdate(resource);		
	}

	public void storeReserver(Reserver reserver) {
		getHibernateTemplate().saveOrUpdate(reserver);		
	}

	public Resource findResourceById(Long id) {
		return (Resource) getHibernateTemplate().get(Resource.class, id);
	}

	public List<Resource> listResources() {
		return convertToGenericList(getHibernateTemplate().find("from Resource"));
	}

	public Reserver findReserversById(Long id) {
		return (Reserver) getHibernateTemplate().get(Reserver.class, id);
	}

	public List<Reserver> listReservers() {
		return convertToGenericList(getHibernateTemplate().find("from Reserver"));
	}

	public void deleteResource(int id) {
		Resource resource = getHibernateTemplate().load(Resource.class, id);
		deleteResource(resource);
	}

	public void deleteResource(Resource resource) {
		getHibernateTemplate().delete(resource);		
	}

	public void deleteReserver(int id) {
		Reserver reservation = getHibernateTemplate().load(Reserver.class, id);
		deleteReserver(reservation);
	}

	public void deleteReserver(Reserver reserver) {
		getHibernateTemplate().delete(reserver);
		
	}

}
