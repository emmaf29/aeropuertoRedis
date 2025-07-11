package com.aeropuerto.aeropuerto.entity;

import java.io.Serializable;

import com.aeropuerto.aeropuerto.Dto.PuedeAterrizarDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "puedeaterrizar")
public class PuedeAterrizar implements Serializable {

    @EmbeddedId
    private PuedeAterrizarId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tipoDeAvion") 
    @JoinColumn(name = "nombretipodeavion")
    private TipoDeAvion tipoDeAvion;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("aeropuerto") 
    @JoinColumn(name = "nombreaeropuerto")
    private Aeropuerto aeropuerto;

    public PuedeAterrizar() {
    }

    public PuedeAterrizarDTO toDto() {
        PuedeAterrizarDTO dto = new PuedeAterrizarDTO();
        dto.setTipoDeAvionId(tipoDeAvion != null ? tipoDeAvion.getId() : null);
        dto.setAeropuertoId(aeropuerto != null ? aeropuerto.getId() : null);
        return dto;
    }

    public PuedeAterrizarId getId() {
        return id;
    }

    public void setId(PuedeAterrizarId id) {
        this.id = id;
    }

    public TipoDeAvion getTipoDeAvion() {
        return tipoDeAvion;
    }

    public void setTipoDeAvion(TipoDeAvion tipoDeAvion) {
        this.tipoDeAvion = tipoDeAvion;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
}
