package se.danero.examples.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name="findById", query="from Reservation where id = :id")
@Table(name="Reservation")
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 908391408217347489L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;

	@OneToOne(targetEntity=Reserver.class)
	private Reserver reserver;

	@OneToOne(targetEntity=Resource.class)
	private Resource resource;

	public Reservation(Date start, Date end, Reserver reserver, Resource resource) {
		if (start == null || end == null || reserver == null || resource == null) {
			throw new IllegalArgumentException("Null-values not allowed");
		}

		this.startDate = new Date(start.getTime()); // Defensive copy
		this.endDate   = new Date(end.getTime());
		this.reserver  = reserver;
		this.resource  = resource;
	}
	
	public Reservation() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Reserver getReserver() {
		return reserver;
	}

	public void setReserver(Reserver reserver) {
		this.reserver = reserver;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Reservation)) {
			return false;
		}
		Reservation r = (Reservation) o;
		return r.id == id && r.startDate.equals(startDate) && r.endDate.equals(endDate) && r.reserver == reserver && r.resource == resource;
	}
	
	@Override
	public int hashCode() {
		int result = 7;
		result = 31 * result + id;
		result = 31 * result + startDate.hashCode();
		result = 31 * result + endDate.hashCode();
		result = 31 * result + reserver.hashCode();
		result = 31 * result + resource.hashCode();
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation {id=" + this.id + ", ");
		sb.append("startdate=" + startDate + ", ");
		sb.append("enddate=" + endDate + ", ");
		sb.append(resource + ", ");
		sb.append(reserver + "}");
		return sb.toString();
	}
	
}
