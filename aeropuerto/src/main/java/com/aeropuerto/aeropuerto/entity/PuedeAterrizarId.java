package com.aeropuerto.aeropuerto.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public class PuedeAterrizarId implements Serializable {
    private UUID tipoDeAvion;
    private UUID aeropuerto;

    public PuedeAterrizarId() {
    }

    public PuedeAterrizarId(UUID tipoDeAvion, UUID aeropuerto) {
        this.tipoDeAvion = tipoDeAvion;
        this.aeropuerto = aeropuerto;
    }

    public UUID getTipoDeAvion() {
        return tipoDeAvion;
    }

    public void setTipoDeAvion(UUID tipoDeAvion) {
        this.tipoDeAvion = tipoDeAvion;
    }

    public UUID getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(UUID aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PuedeAterrizarId that)) return false;
        return Objects.equals(tipoDeAvion, that.tipoDeAvion) &&
               Objects.equals(aeropuerto, that.aeropuerto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDeAvion, aeropuerto);
    }
}
