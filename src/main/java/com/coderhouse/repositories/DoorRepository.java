package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Door;

public interface DoorRepository extends JpaRepository<Door, Long>{

}
