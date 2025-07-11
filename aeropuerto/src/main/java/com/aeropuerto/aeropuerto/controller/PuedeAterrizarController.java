package com.aeropuerto.aeropuerto.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeropuerto.aeropuerto.Dto.PuedeAterrizarDTO;
import com.aeropuerto.aeropuerto.service.PuedeAterrizarService;

@RestController
@RequestMapping("/puedeaterrizar")
public class PuedeAterrizarController {

    @Autowired
    private PuedeAterrizarService service;

    @GetMapping("/{tipoId}/{aeropuertoId}")
    public ResponseEntity<PuedeAterrizarDTO> getById(
            @PathVariable UUID tipoId,
            @PathVariable UUID aeropuertoId) {
        return service.getById(tipoId, aeropuertoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PuedeAterrizarDTO> upsert(@RequestBody PuedeAterrizarDTO dto) {
        return ResponseEntity.ok(service.upsert(dto));
    }
}

