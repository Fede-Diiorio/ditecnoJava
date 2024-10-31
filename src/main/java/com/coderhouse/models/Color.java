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
@Table(name = "colors")
public class Color {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 30, nullable = false, unique = true)
	private String slug;

	@Column(length = 200, nullable = false)
	private String image;

	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
	List<Window> windows = new ArrayList<Window>();

	// Constructors
	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Color(String name, String slug, String image) {
		super();
		this.name = name;
		this.slug = slug;
		this.image = image;
	}

	// GET y SET
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", name=" + name + ", slug=" + slug + ", image=" + image + "]";
	}

}
