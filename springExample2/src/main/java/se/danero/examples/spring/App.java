package se.danero.examples.spring;

import java.util.Date;

import se.danero.examples.spring.model.Reservation;
import se.danero.examples.spring.model.Reserver;
import se.danero.examples.spring.model.Resource;

/**
 * Small Test
 * 
 */
public class App {
	public static void main(String[] args) {
	
		Date start = new Date(2010, 9, 2, 12, 0);
		Date end   = new Date(2010, 9, 2, 12, 15);
		Resource resource = new Resource();
		resource.setName("Lars Bergman");
		
		Reserver reserver = new Reserver();
		reserver.setName("Robert Nordin");
		
		Reservation res = new Reservation(start, end, reserver, resource);
		
		
		
	}
}
