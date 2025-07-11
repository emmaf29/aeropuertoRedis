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

import com.aeropuerto.aeropuerto.Dto.TipoDeAvionDTO;
import com.aeropuerto.aeropuerto.service.TipoDeAvionService;

@RestController
@RequestMapping("tipodeavion")
public class TipoDeAvionController {
	@Autowired
	private TipoDeAvionService service;
	
	@GetMapping("/{id}")
    public ResponseEntity<TipoDeAvionDTO> getById(@PathVariable UUID id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoDeAvionDTO> upsert(@RequestBody TipoDeAvionDTO dto) {
        return ResponseEntity.ok(service.upsert(dto));
    }
}
