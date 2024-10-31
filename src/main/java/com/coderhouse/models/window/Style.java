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
@Table(name = "windows_styles")
public class Style {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(length = 20, nullable = false)
	private String slug;
	
	@Column(length = 200)
	private String image;
	
	@ManyToMany(mappedBy = "styles", fetch = FetchType.EAGER)
	List<Openness> openness = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "windows_details", joinColumns = @JoinColumn(name = "style_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private List<Type> types = new ArrayList<Type>();

	//Constructors
	public Style() {
		super();
	}

	public Style(String name, String slug) {
		super();
		this.name = name;
		this.slug = slug;
	}

	public Style(String name, String slug, String image) {
		super();
		this.name = name;
		this.slug = slug;
		this.image = image;
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

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", name=" + name + ", slug=" + slug + ", image=" + image + "]";
	}
	
	
}
