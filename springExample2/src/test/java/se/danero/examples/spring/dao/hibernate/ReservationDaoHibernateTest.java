package se.danero.examples.spring.dao.hibernate;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.danero.examples.spring.model.Reservation;
import se.danero.examples.spring.model.Reserver;
import se.danero.examples.spring.model.Resource;

public class ReservationDaoHibernateTest extends TestCase {

	private ApplicationContext      ctx         = null;
	private Reservation             reservation = null;
	private ReservationDaoHibernate dao         = null;
	
	public ReservationDaoHibernateTest() {
        String[] paths = {"applicationContext.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		dao = (ReservationDaoHibernate) ctx.getBean("reservationDAO");
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}
	
	public void testToStoreReservation() throws Exception {
		
		Resource resource = new Resource();
		resource.setName("Lars Bergman");
		dao.storeResource(resource);
		
		
		
		Reserver reserver = new Reserver();
		reserver.setName("Robert Nordin");
		dao.storeReserver(reserver);
		
		reservation = new Reservation();
		
		reservation.setReserver(reserver);
		reservation.setResource(resource);
	
		DateTime start = new DateTime(2010, 9, 2, 18, 15, 0, 0);
		DateTime end   = new DateTime(2010, 9, 2, 18, 30, 0, 0);
		System.out.println(start);
			
		
		
		reservation.setStartDate(start.toDate());
		reservation.setEndDate(end.toDate());
		
			
		dao.storeReservation(reservation);
		
		Assert.assertNotNull("Primary key assigned", reservation.getId());

		reservation = new Reservation();
		reservation.setReserver(reserver);
		reservation.setResource(resource);
		reservation.setStartDate(new DateTime(2010, 9, 8, 14, 14, 30, 0).toDate());
		reservation.setEndDate(new DateTime(2010, 9, 8, 14, 15, 30, 0).toDate());
		dao.storeReservation(reservation);
	}
	
}
