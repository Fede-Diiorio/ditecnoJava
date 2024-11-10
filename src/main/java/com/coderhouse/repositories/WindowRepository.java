package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Window;

public interface WindowRepository extends JpaRepository<Window, Long> {

}
