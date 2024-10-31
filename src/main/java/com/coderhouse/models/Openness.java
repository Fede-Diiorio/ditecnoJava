package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "openness")
public class Openness {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(length = 20, nullable = false, unique = true)
	private String slug;
	
	@OneToMany(mappedBy = "openness", fetch = FetchType.EAGER)
	List<Window> windows = new ArrayList<Window>();

	//Constructors
	public Openness() {
		super();
	}

	public Openness(String name, String slug) {
		super();
		this.name = name;
		this.slug = slug;
	}

	//GET y SET
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Openness [id=" + id + ", name=" + name + ", slug=" + slug + "]";
	}

	
}
