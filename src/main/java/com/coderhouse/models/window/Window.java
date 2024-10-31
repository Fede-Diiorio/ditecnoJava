package com.coderhouse.models.window;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "windows")
public class Window {

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

	@ManyToOne
	@JoinColumn(name = "openness_id", nullable = false)
	private WindowOpenness openness;

	@ManyToOne
	@JoinColumn(name = "style_id", nullable = false)
	private WindowStyle style;

	// Constructors
	public Window() {
		super();
	}

	public Window(String name, String slug, String image, byte casementQuantity, WindowOpenness openness,
			WindowStyle style) {
		super();
		validateCasement(casementQuantity);
		this.name = name;
		this.slug = slug;
		this.image = image;
		this.casementQuantity = casementQuantity;
		this.openness = openness;
		this.style = style;
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
		return "Window [id=" + id + ", name=" + name + ", slug=" + slug + ", image=" + image + ", casementQuantity="
				+ casementQuantity + ", openness=" + openness + ", style=" + style + "]";
	}

	

}
