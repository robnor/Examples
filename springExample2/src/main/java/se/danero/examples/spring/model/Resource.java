package se.danero.examples.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resource implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long   id;
	
	@Column(name="name")
	private String name;
	
	public Resource() {
		
	}

	public Long getId() {
		return Long.valueOf(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
