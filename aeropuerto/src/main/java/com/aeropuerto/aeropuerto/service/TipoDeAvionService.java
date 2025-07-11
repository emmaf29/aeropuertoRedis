package com.aeropuerto.aeropuerto.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeropuerto.aeropuerto.Dto.TipoDeAvionDTO;
import com.aeropuerto.aeropuerto.entity.TipoDeAvion;
import com.aeropuerto.aeropuerto.repository.TipoDeAvionRepository;

@Service
public class TipoDeAvionService {

    @Autowired
    private TipoDeAvionRepository repo;

    public Optional<TipoDeAvionDTO> getById(UUID id) {
        return repo.findById(id).map(TipoDeAvion::toDto);
    }

    public TipoDeAvionDTO upsert(TipoDeAvionDTO dto) {
        TipoDeAvion tipo = new TipoDeAvion();
        tipo.setId(dto.getId() != null ? dto.getId() : UUID.randomUUID());
        tipo.setNombreTipoDeAvion(dto.getNombreTipoDeAvion());
        tipo.setCantidadMaximaAsientos(dto.getCantidadMaximaAsientos());
        tipo.setEmpresa(dto.getEmpresa());
        return repo.save(tipo).toDto();
    }
}
