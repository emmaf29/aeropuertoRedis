package com.aeropuerto.aeropuerto.Dto;

import java.util.UUID;

public class TipoDeAvionDTO {
    private UUID id;
    private String nombreTipoDeAvion;
    private int cantidadMaximaAsientos;
    private String empresa;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNombreTipoDeAvion() {
		return nombreTipoDeAvion;
	}
	public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
		this.nombreTipoDeAvion = nombreTipoDeAvion;
	}
	public int getCantidadMaximaAsientos() {
		return cantidadMaximaAsientos;
	}
	public void setCantidadMaximaAsientos(int cantidadMaximaAsientos) {
		this.cantidadMaximaAsientos = cantidadMaximaAsientos;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

    
}
