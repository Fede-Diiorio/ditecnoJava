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
@Table(name = "doors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Door {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne
	@JoinColumn(name = "design_id", nullable = false)
	private DoorDesign design;

	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	private DoorType type;

	@ManyToOne
	@JoinColumn(name = "style_id", nullable = false)
	private DoorStyle style;

	@ManyToOne
	@JoinColumn(name = "openess_id", nullable = false)
	private Openness openness;
}
