package com.coderhouse.models.window;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "windows_types")
public class Type {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 70, nullable = false)
	private String name;
	
	@Column(length = 20, nullable = false)
	private String slug;
	
	@Column(length = 200)
	private String image;
	
	@Column(nullable = false)
	private byte casementQuantity;
	
	@ManyToMany(mappedBy = "types", fetch = FetchType.EAGER)
	List<Style> styles = new ArrayList<Style>();

	//Constructors
	public Type() {
		super();
	}

	public Type(String name, String slug, byte casementQuantity) {
		super();
		validateCasement(casementQuantity);
		this.name = name;
		this.slug = slug;
		this.casementQuantity = casementQuantity;
	}

	public Type(String name, String slug, String image, byte casementQuantity) {
		super();
		validateCasement(casementQuantity);
		this.name = name;
		this.slug = slug;
		this.image = image;
		this.casementQuantity = casementQuantity;
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
	
	//Methods
	private void validateCasement(byte casementQuantity) {
		if(casementQuantity < 1 || casementQuantity > 5) {
			throw new IllegalArgumentException("Debe ingresar una cantidad de paños válida.");
		}
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", slug=" + slug + ", image=" + image + ", casementeQuantity="
				+ casementQuantity + "]";
	}
	
	
}
