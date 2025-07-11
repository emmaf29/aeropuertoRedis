package com.aeropuerto.aeropuerto.entity;

import java.time.LocalTime;
import java.util.UUID;

import com.aeropuerto.aeropuerto.Dto.VueloDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @Column(name = "numerodevuelo")
    private UUID numeroDeVuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numeroserieavion")
    private Avion avion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuertosalida")
    private Aeropuerto aeropuertoSalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuertollegada")
    private Aeropuerto aeropuertoLlegada;
    @Column(name = "horasalida")
    private LocalTime horaSalida;
    @Column(name = "horallegada")
    private LocalTime horaLlegada;

    public Vuelo() {
        this.numeroDeVuelo = UUID.randomUUID();
    }

    public VueloDTO toDto() {
        VueloDTO dto = new VueloDTO();
        dto.setNumeroDeVuelo(numeroDeVuelo);;
        dto.setAvionId(avion != null ? avion.getNumeroSerieAvion() : null);
        dto.setAeropuertoSalidaId(aeropuertoSalida != null ? aeropuertoSalida.getId() : null);
        dto.setAeropuertoLlegadaId(aeropuertoLlegada != null ? aeropuertoLlegada.getId() : null);
        dto.setHoraSalida(horaSalida);
        dto.setHoraLlegada(horaLlegada);
        return dto;
    }


	public UUID getNumeroDeVuelo() {
		return numeroDeVuelo;
	}

	public void setNumeroDeVuelo(UUID numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Aeropuerto getAeropuertoSalida() {
		return aeropuertoSalida;
	}

	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		this.aeropuertoSalida = aeropuertoSalida;
	}

	public Aeropuerto getAeropuertoLlegada() {
		return aeropuertoLlegada;
	}

	public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
		this.aeropuertoLlegada = aeropuertoLlegada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
    
    
}