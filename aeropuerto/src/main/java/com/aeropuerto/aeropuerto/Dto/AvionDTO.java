package com.aeropuerto.aeropuerto.Dto;

import java.util.UUID;

public class AvionDTO {
    private UUID numeroSerieAvion;
    private String nombreTipoDeAvion;
    private Integer totalDeAsientos;
    

	
	public UUID getNumeroSerieAvion() {
		return numeroSerieAvion;
	}
	
	public void setNumeroSerieAvion(UUID numeroSerieAvion2) {
		this.numeroSerieAvion = numeroSerieAvion2;
	}
	
	public String getNombreTipoDeAvion() {
		return nombreTipoDeAvion;
	}
	
	public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
		this.nombreTipoDeAvion = nombreTipoDeAvion;
	}
	
	public Integer getTotalDeAsientos() {
		return totalDeAsientos;
	}
	
	public void setTotalDeAsientos(Integer totalDeAsientos) {
		this.totalDeAsientos = totalDeAsientos;
	}
    
}