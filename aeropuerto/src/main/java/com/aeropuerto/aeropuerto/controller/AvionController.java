package com.aeropuerto.aeropuerto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aeropuerto.aeropuerto.Dto.AvionDTO;
import com.aeropuerto.aeropuerto.service.AvionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aviones")
public class AvionController {
    @Autowired
    private AvionService service;

    @GetMapping("/{id}")
    public ResponseEntity<AvionDTO> getById(@PathVariable UUID id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/sinVuelo")
    public List<AvionDTO> getAvionesSinVuelos(){
    	return service.avionesSinVuelos();
    }

    @PostMapping
    public ResponseEntity<AvionDTO> upsert(@RequestBody AvionDTO dto) {
        return ResponseEntity.ok(service.upsert(dto));
    }
}
