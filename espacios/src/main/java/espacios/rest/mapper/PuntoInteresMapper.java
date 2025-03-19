package espacios.rest.mapper;

import espacios.modelo.PuntoInteres;
import espacios.rest.dto.PuntoInteresDTO;

public class PuntoInteresMapper {

    private PuntoInteresMapper() {
    }

    public static PuntoInteres fromDTO(PuntoInteresDTO puntoDTO) {
        PuntoInteres punto = new PuntoInteres();
        punto.setNombre(puntoDTO.getNombre());
        punto.setDescripcion(puntoDTO.getDescripcion());
        punto.setDistancia(puntoDTO.getDistancia());
        punto.setUrl(puntoDTO.getUrl());
        return punto;
    }
}
