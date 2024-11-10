package com.coderhouse.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

	Optional<Color> findColorBySlug(String slug);
}
