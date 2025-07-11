package com.aeropuerto.aeropuerto.Dto;

import java.time.LocalTime;
import java.util.UUID;

public class VueloDTO {
    private UUID numeroDeVuelo;
    private UUID avionId;
    private UUID aeropuertoSalidaId;
    private UUID aeropuertoLlegadaId;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;



    public UUID getNumeroDeVuelo() {
		return numeroDeVuelo;
	}

	public void setNumeroDeVuelo(UUID numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}

	public UUID getAvionId() {
        return avionId;
    }

    public void setAvionId(UUID avionId) {
        this.avionId = avionId;
    }

    public UUID getAeropuertoSalidaId() {
        return aeropuertoSalidaId;
    }

    public void setAeropuertoSalidaId(UUID aeropuertoSalidaId) {
        this.aeropuertoSalidaId = aeropuertoSalidaId;
    }

    public UUID getAeropuertoLlegadaId() {
        return aeropuertoLlegadaId;
    }

    public void setAeropuertoLlegadaId(UUID aeropuertoLlegadaId) {
        this.aeropuertoLlegadaId = aeropuertoLlegadaId;
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