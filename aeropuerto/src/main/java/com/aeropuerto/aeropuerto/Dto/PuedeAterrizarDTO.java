package com.aeropuerto.aeropuerto.Dto;

import java.util.UUID;

public class PuedeAterrizarDTO {

    private UUID tipoDeAvionId;
    private UUID aeropuertoId;

    public UUID getTipoDeAvionId() {
        return tipoDeAvionId;
    }

    public void setTipoDeAvionId(UUID tipoDeAvionId) {
        this.tipoDeAvionId = tipoDeAvionId;
    }

    public UUID getAeropuertoId() {
        return aeropuertoId;
    }

    public void setAeropuertoId(UUID aeropuertoId) {
        this.aeropuertoId = aeropuertoId;
    }
}
