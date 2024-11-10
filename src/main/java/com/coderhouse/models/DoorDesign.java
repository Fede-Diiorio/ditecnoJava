package com.coderhouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "doors_designs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DoorDesign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 70, nullable = false)
	private String name;

	@Column(length = 70, nullable = false)
	private String slug;

	public void setSlug(String slug) {
		validateSlug(slug);
		this.slug = slug;
	}

	// Methods
	private String validateSlug(String slug) {
		if (slug == null) {
			return "sin-categoria";
		}
		return slug.toLowerCase().replace(" ", "-");
	}
}
