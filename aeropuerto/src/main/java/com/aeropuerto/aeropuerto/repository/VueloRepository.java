package com.aeropuerto.aeropuerto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.aeropuerto.entity.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, UUID> {
	
}