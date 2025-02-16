package espacios.rest;

import espacios.modelo.EspacioFisico;

public class EspacioFisicoMapper {

    public EspacioFisicoMapper() {
        throw new UnsupportedOperationException("No se permite instanciar esta clase");
    }

    public static EspacioFisico toEntity(EspacioFisicoDTO dto) {
        EspacioFisico espacio = new EspacioFisico();
        espacio.setId(dto.getId());
        espacio.setNombre(dto.getNombre());
        espacio.setPropietario(dto.getPropietario());
        espacio.setCapacidad(dto.getCapacidad());
        espacio.setDireccion(dto.getDireccion());
        espacio.setLongitud(dto.getLongitud());
        espacio.setLatitud(dto.getLatitud());
        espacio.setDescripcion(dto.getDescripcion());

        return espacio;
    }

    public static EspacioFisicoDTO toDTO(EspacioFisico espacio) {
        EspacioFisicoDTO dto = new EspacioFisicoDTO();
        dto.setId(espacio.getId());
        dto.setNombre(espacio.getNombre());
        dto.setPropietario(espacio.getPropietario());
        dto.setCapacidad(espacio.getCapacidad());
        dto.setDireccion(espacio.getDireccion());
        dto.setLongitud(espacio.getLongitud());
        dto.setLatitud(espacio.getLatitud());
        dto.setDescripcion(espacio.getDescripcion());

        return dto;
    }
}