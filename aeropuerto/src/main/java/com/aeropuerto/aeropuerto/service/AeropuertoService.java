package com.aeropuerto.aeropuerto.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.aeropuerto.aeropuerto.Dto.AeropuertoDTO;
import com.aeropuerto.aeropuerto.entity.Aeropuerto;
import com.aeropuerto.aeropuerto.repository.AeropuertoRepository;

@Service
public class AeropuertoService {
    @Autowired
    private AeropuertoRepository repo;

    @Cacheable(value = "aeropuertoStore", key = "#id")
    public Optional<AeropuertoDTO> getAeropuertoById(UUID id) {
        return repo.findById(id).map(Aeropuerto::toDto);
    }

    public AeropuertoDTO upsertAeropuerto(AeropuertoDTO dto) {
        Aeropuerto a = new Aeropuerto();
        a.setId(dto.getId() != null ? dto.getId() : UUID.randomUUID());
        a.setNombreAeropuerto(dto.getNombreAeropuerto());
        a.setCiudad(dto.getCiudad());
        a.setPais(dto.getPais());
        return repo.save(a).toDto();
    }
}