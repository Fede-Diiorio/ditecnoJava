package com.coderhouse.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "windows")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Window {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "openness_id", nullable = false)
	private Openness openness;

	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	private WindowType type;

	@ManyToOne
	@JoinColumn(name = "style_id", nullable = false)
	private WindowStyle style;

	@ManyToOne
	@JoinColumn(name = "color_id", nullable = false)
	private Color color;

}
