package com.aeropuerto.aeropuerto.entity;

import java.time.LocalTime;
import java.util.UUID;

import com.aeropuerto.aeropuerto.Dto.EscalaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "escalas")
public class Escala {

   
	@Id
	@Column(name = "numerodeescala")
    private UUID numeroDeEscala;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numerodevuelo")
    private Vuelo vuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idaeropuerto")
    private Aeropuerto aeropuerto;
    @Column(name = "horallegada")
    private LocalTime horaLlegada;
    @Column(name = "horapartida")
    private LocalTime horaPartida;

    public Escala() {
        this.numeroDeEscala = UUID.randomUUID();
    }

    public EscalaDTO toDto() {
        EscalaDTO dto = new EscalaDTO();
        dto.setVueloId(vuelo != null ? vuelo.getNumeroDeVuelo() : null);
        dto.setNumeroEscala(numeroDeEscala);;
        dto.setAeropuertoId(aeropuerto != null ? aeropuerto.getId() : null);
        dto.setHoraLlegada(horaLlegada);
        dto.setHoraPartida(horaPartida);
        return dto;
    }


	public UUID getNumeroDeEscala() {
		return numeroDeEscala;
	}

	public void setNumeroDeEscala(UUID numeroDeEscala) {
		this.numeroDeEscala = numeroDeEscala;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public LocalTime getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}
} 