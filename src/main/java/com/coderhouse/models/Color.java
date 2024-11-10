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
@Table(name = "colors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
	
	@OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
	List<Door> doors = new ArrayList<Door>();

}
