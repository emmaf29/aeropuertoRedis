package com.aeropuerto.aeropuerto.Dto;

import java.util.UUID;

public class AeropuertoDTO {
    private UUID id;
    private String nombreAeropuerto;
    private String ciudad;
    private String pais;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}
	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

    
}