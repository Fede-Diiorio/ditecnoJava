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
@Table(name = "windows_styles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WindowStyle {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(length = 20, nullable = false, unique = true)
	private String slug;

	@Column(length = 200)
	private String image;

	@OneToMany(mappedBy = "style", fetch = FetchType.LAZY)
	List<Window> windows = new ArrayList<Window>();

	public WindowStyle(String name, String slug) {
		super();
		this.name = name;
		this.slug = slug;
	}

}
