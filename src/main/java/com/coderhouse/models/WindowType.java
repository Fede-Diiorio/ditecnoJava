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
@Table(name = "windows_types")
public class WindowType {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 70, nullable = false)
	private String name;

	@Column(length = 40, nullable = false, unique = true)
	private String slug;

	@Column(length = 200)
	private String image;

	@Column(nullable = false)
	private byte casementQuantity;

	@OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
	List<Window> windows = new ArrayList<Window>();

	// Constructors
	public WindowType() {
		super();
	}

	public WindowType(String name, String slug, String image, byte casementQuantity) {
		super();
		validateCasement(casementQuantity);
		this.name = name;
		this.slug = slug;
		this.image = image;
		this.casementQuantity = casementQuantity;
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

	public byte getCasementQuantity() {
		return casementQuantity;
	}

	public void setCasementQuantity(byte casementQuantity) {
		validateCasement(casementQuantity);
		this.casementQuantity = casementQuantity;
	}

	public long getId() {
		return id;
	}

	// Methods
	private void validateCasement(byte casementQuantity) {
		if (casementQuantity < 1 || casementQuantity > 5) {
			throw new IllegalArgumentException("Debe ingresar una cantidad de paños válida.");
		}
	}

	@Override
	public String toString() {
		return "WindowType [id=" + id + ", name=" + name + ", slug=" + slug + ", image=" + image + ", casementQuantity="
				+ casementQuantity + "]";
	}

	
}
