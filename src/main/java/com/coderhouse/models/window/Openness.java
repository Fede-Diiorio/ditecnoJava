package com.coderhouse.models.window;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "windows_openness")
public class Openness {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(length = 20, nullable = false)
	private String slug;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "windows_details", joinColumns = @JoinColumn(name = "openness_id"), inverseJoinColumns = @JoinColumn(name = "style_id"))
	private List<Style> styles = new ArrayList<>();

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
