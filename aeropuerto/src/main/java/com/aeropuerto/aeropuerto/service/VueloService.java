package com.aeropuerto.aeropuerto.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeropuerto.aeropuerto.Dto.VueloDTO;
import com.aeropuerto.aeropuerto.entity.Aeropuerto;
import com.aeropuerto.aeropuerto.entity.Avion;
import com.aeropuerto.aeropuerto.entity.Vuelo;
import com.aeropuerto.aeropuerto.repository.AeropuertoRepository;
import com.aeropuerto.aeropuerto.repository.AvionRepository;
import com.aeropuerto.aeropuerto.repository.VueloRepository;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    public Optional<VueloDTO> getVueloById(UUID id) {
        return vueloRepository.findById(id).map(Vuelo::toDto);
    }

    public VueloDTO saveVuelo(VueloDTO dto) {
        Vuelo vuelo = new Vuelo();
        vuelo.setNumeroDeVuelo(dto.getNumeroDeVuelo() != null ? dto.getNumeroDeVuelo() : UUID.randomUUID());

        Avion avion = avionRepository.findById(dto.getAvionId()).orElse(null);
        Aeropuerto salida = aeropuertoRepository.findById(dto.getAeropuertoSalidaId()).orElse(null);
        Aeropuerto llegada = aeropuertoRepository.findById(dto.getAeropuertoLlegadaId()).orElse(null);

        vuelo.setAvion(avion);
        vuelo.setAeropuertoSalida(salida);
        vuelo.setAeropuertoLlegada(llegada);
        vuelo.setHoraSalida(dto.getHoraSalida());
        vuelo.setHoraLlegada(dto.getHoraLlegada());

        return vueloRepository.save(vuelo).toDto();
    }
}