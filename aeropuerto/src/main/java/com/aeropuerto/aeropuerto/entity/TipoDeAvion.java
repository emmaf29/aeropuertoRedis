package com.aeropuerto.aeropuerto.entity;

import java.util.UUID;

import com.aeropuerto.aeropuerto.Dto.TipoDeAvionDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipodeavion")
public class TipoDeAvion {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(name = "nombretipodeavion")
	private String nombreTipoDeAvion;
	@Column(name = "cantidadmaximaasientos")
	private Integer cantidadMaximaAsientos;
	@Column(name = "empresa")
	private String empresa;
	
	public TipoDeAvion() {
        this.id = UUID.randomUUID();
    }

	 public TipoDeAvionDTO toDto() {
	        TipoDeAvionDTO dto = new TipoDeAvionDTO();
	        dto.setId(id);
	        dto.setNombreTipoDeAvion(nombreTipoDeAvion);
	        dto.setCantidadMaximaAsientos(cantidadMaximaAsientos);
	        dto.setEmpresa(empresa);
	        return dto;
	    }

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

	public Integer getCantidadMaximaAsientos() {
		return cantidadMaximaAsientos;
	}

	public void setCantidadMaximaAsientos(Integer cantidadMaximaAsientos) {
		this.cantidadMaximaAsientos = cantidadMaximaAsientos;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	 
}