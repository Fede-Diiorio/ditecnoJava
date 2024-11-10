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
@Table(name = "doors_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DoorType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 70, nullable = false)
	private String name;

	@Column(length = 40, nullable = false, unique = true)
	private String slug;

	@Column(length = 200)
	private String image = "Sin Imagen";

	@Column(nullable = false)
	private byte casementQuantity;

	@Column(nullable = false, length = 100)
	private String casementName = "Medida de hoja [metros]";

	@OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
	private List<Door> doors = new ArrayList<>();

	public void setImage(String image) {
		this.image = (image != null) ? image : "Sin Imagen";
	}

	public void setCasementName(String casementName) {
		this.casementName = (casementName != null) ? casementName : "Medida de hoja [metros]";
	}
}
