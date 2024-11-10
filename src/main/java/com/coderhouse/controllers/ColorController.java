package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Color;
import com.coderhouse.services.ColorService;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

	@Autowired
	private ColorService colorService;

	@GetMapping
	public ResponseEntity<List<Color>> getAllColors() {
		try {
			List<Color> colors = colorService.findAllRegisters();
			return ResponseEntity.ok(colors);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{slug}")
	public ResponseEntity<Color> getColorBySlug(@PathVariable String slug) {
		try {
			Color color = colorService.findBySlug(slug);
			return ResponseEntity.ok(color);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}