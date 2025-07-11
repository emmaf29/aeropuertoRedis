package com.aeropuerto.aeropuerto.entity;

import jakarta.persistence.*;

import com.aeropuerto.aeropuerto.Dto.AvionDTO;

import java.util.UUID;

@Entity
@Table(name = "avion")
public class Avion {

    @Id
    @GeneratedValue
    @Column(name = "numerodeserieavion") 
    private UUID numeroSerieAvion;
    
    //EL ERROR ESTA ACA
    @ManyToOne
    @JoinColumn(name = "tipodeavion")
    private TipoDeAvion tipodeavion;
    @Column(name = "totaldeasientos")
    private Integer totalDeAsientos;

    public AvionDTO toDto() {
        AvionDTO dto = new AvionDTO();
        dto.setNumeroSerieAvion(this.numeroSerieAvion);
        dto.setNombreTipoDeAvion(this.tipodeavion.getNombreTipoDeAvion());
        dto.setTotalDeAsientos(this.totalDeAsientos);
        return dto;
    }

	
	public TipoDeAvion getTipodeavion() {
		return tipodeavion;
	}


	public void setTipodeavion(TipoDeAvion tipodeavion) {
		this.tipodeavion = tipodeavion;
	}


	public UUID getNumeroSerieAvion() {
		return numeroSerieAvion;
	}


	public void setNumeroSerieAvion(UUID numeroSerieAvion) {
		this.numeroSerieAvion = numeroSerieAvion;
	}



	public Integer getTotalDeAsientos() {
		return totalDeAsientos;
	}

	public void setTotalDeAsientos(Integer totalDeAsientos) {
		this.totalDeAsientos = totalDeAsientos;
	}
}