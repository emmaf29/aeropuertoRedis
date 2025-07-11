package com.aeropuerto.aeropuerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aeropuerto.aeropuerto.entity.Avion;

import java.util.List;
import java.util.UUID;

@Repository
public interface AvionRepository extends JpaRepository<Avion, UUID> {
	@Query("""
		      SELECT a 
		      FROM Avion a 
		      LEFT JOIN Vuelo v ON v.avion = a 
		      WHERE v.id IS NULL
		    """)
		    List<Avion> findAvionesSinVuelo();
}