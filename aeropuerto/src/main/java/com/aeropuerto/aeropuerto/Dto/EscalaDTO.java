package com.aeropuerto.aeropuerto.Dto;

import java.time.LocalTime;
import java.util.UUID;

public class EscalaDTO {
    private UUID vueloId;
    private UUID numeroEscala;
    private UUID aeropuertoId;
    private LocalTime horaLlegada;
    private LocalTime horaPartida;

	public UUID getVueloId() {
		return vueloId;
	}
	public void setVueloId(UUID vueloId) {
		this.vueloId = vueloId;
	}
	public UUID getNumeroEscala() {
		return numeroEscala;
	}
	public void setNumeroEscala(UUID numeroDeEscala) {
		this.numeroEscala = numeroDeEscala;
	}
	public UUID getAeropuertoId() {
		return aeropuertoId;
	}
	public void setAeropuertoId(UUID aeropuertoId) {
		this.aeropuertoId = aeropuertoId;
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