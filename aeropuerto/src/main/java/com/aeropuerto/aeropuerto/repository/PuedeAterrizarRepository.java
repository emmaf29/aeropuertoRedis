package com.aeropuerto.aeropuerto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.aeropuerto.entity.PuedeAterrizar;
import com.aeropuerto.aeropuerto.entity.PuedeAterrizarId;

@Repository
public interface PuedeAterrizarRepository extends JpaRepository<PuedeAterrizar, PuedeAterrizarId> {}
