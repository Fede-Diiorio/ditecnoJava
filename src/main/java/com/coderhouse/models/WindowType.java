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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "windows_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

	public WindowType(String name, String slug, String image, byte casementQuantity) {
		super();
		validateCasement(casementQuantity);
		this.name = name;
		this.slug = slug;
		this.image = image;
		this.casementQuantity = casementQuantity;
	}

	public void setCasementQuantity(byte casementQuantity) {
		validateCasement(casementQuantity);
		this.casementQuantity = casementQuantity;
	}

	// Methods
	private void validateCasement(byte casementQuantity) {
		if (casementQuantity < 1 || casementQuantity > 5) {
			throw new IllegalArgumentException("Debe ingresar una cantidad de paños válida.");
		}
	}

}
