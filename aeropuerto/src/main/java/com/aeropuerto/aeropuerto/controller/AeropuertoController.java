package com.aeropuerto.aeropuerto.controller;

import com.aeropuerto.aeropuerto.Dto.AeropuertoDTO;
import com.aeropuerto.aeropuerto.service.AeropuertoService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aeropuertos")
public class AeropuertoController {
    @Autowired
    private AeropuertoService service;

    @GetMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> getAeropuertoById(@PathVariable UUID id) {
        return service.getAeropuertoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AeropuertoDTO> upsertAeropuerto(@RequestBody AeropuertoDTO dto) {
        return ResponseEntity.ok(service.upsertAeropuerto(dto));
    }
}
