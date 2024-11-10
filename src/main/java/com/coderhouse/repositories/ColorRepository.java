package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

}
