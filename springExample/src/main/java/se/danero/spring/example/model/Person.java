package se.danero.spring.example.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	
	@Id
	@Column(name = "id")
	private int	id		 = 1;
	@Column(name = "name")
	private String name	   = null;
	@Column(name = "last_name")
	private String lastName   = null;
	@Column(name = "middle_name")
	private String middleName = null;

	public Person(int id, String name, String lastName, String middleName) {
		this.id = id;
		this.middleName = middleName;
		this.lastName = lastName;
		this.name = name;
	}

	public Person() {
		// Empty constructor
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.name + " " + this.lastName + " " + this.middleName + " (" + this.id + ")";
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && getClass() == obj.getClass()) {
			final Person other = (Person) obj;
			if (this.id == other.id) {
				result = true;
			}
		}
		return result;
	}
}