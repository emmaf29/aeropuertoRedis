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

import com.aeropuerto.aeropuerto.Dto.VueloDTO;
import com.aeropuerto.aeropuerto.service.VueloService;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> getVueloById(@PathVariable UUID id) {
        return vueloService.getVueloById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VueloDTO> saveVuelo(@RequestBody VueloDTO dto) {
        return ResponseEntity.ok(vueloService.saveVuelo(dto));
    }
}