package se.danero.examples.spring.dao;

import java.util.List;

import se.danero.examples.spring.model.Reservation;
import se.danero.examples.spring.model.Reserver;
import se.danero.examples.spring.model.Resource;

public interface ReservationDao {

	// == Create/Update ==
	public void storeReservation(Reservation reservation);
	public void storeResource(Resource resource);
	public void storeReserver(Reserver reserver);
	
	
	// == Read ==
	public Reservation findReservationById(Long id);
	public List<Reservation> listReservations();
	
	public Resource findResourceById(Long id);
	public List<Resource> listResources();

	public Reserver findReserversById(Long id);
	public List<Reserver> listReservers();

	// == Delete ==
	public void deleteReservation(int id);
	public void deleteReservation(Reservation reservation);
	
	public void deleteResource(int id);
	public void deleteResource(Resource resource);
	
	public void deleteReserver(int id);
	public void deleteReserver(Reserver reserver);
	
	
	
}
