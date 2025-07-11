package com.aeropuerto.aeropuerto.entity;

import jakarta.persistence.*;
import java.util.UUID;

import com.aeropuerto.aeropuerto.Dto.AeropuertoDTO;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nombreaeropuerto")
    private String nombreAeropuerto;

    private String ciudad;
    private String pais;

    public AeropuertoDTO toDto() {
        AeropuertoDTO dto = new AeropuertoDTO();
        dto.setId(this.id);
        dto.setNombreAeropuerto(this.nombreAeropuerto);
        dto.setCiudad(this.ciudad);
        dto.setPais(this.pais);
        return dto;
    }

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