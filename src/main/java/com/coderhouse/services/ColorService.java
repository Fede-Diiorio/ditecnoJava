package com.coderhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.ServiceInterface;
import com.coderhouse.models.Color;
import com.coderhouse.repositories.ColorRepository;

@Service
public class ColorService implements ServiceInterface<Color>{
	
	@Autowired
	private ColorRepository colorRepository;

	@Override
	public List<Color> findAllRegisters() {
		return colorRepository.findAll();
	}

	@Override
	public Color findBySlug(String slug) {
		Optional<Color> color = colorRepository.findColorBySlug(slug);
		return color.orElseThrow(() -> new RuntimeException("Color no encontrado con el slug: " + slug));
	}

}
