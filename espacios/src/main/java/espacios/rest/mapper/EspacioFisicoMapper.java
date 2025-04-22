package espacios.rest.mapper;

import java.util.stream.Collectors;

import espacios.modelo.EspacioFisico;
import espacios.rest.dto.CreateEspacioFisicoDTO;
import espacios.rest.dto.EspacioFisicoResponseDTO;
import espacios.rest.dto.UpdateEspacioFisicoDTO;
import espacios.rest.dto.ResumenEspacioFisicoResponseDTO;

public class EspacioFisicoMapper {

    private EspacioFisicoMapper() {
    }

    public static EspacioFisico toEntity(CreateEspacioFisicoDTO dto) {
        EspacioFisico espacio = new EspacioFisico();
        espacio.setNombre(dto.getNombre());
        espacio.setPropietario(dto.getPropietario());
        espacio.setCapacidad(dto.getCapacidad());
        espacio.setDireccion(dto.getDireccion());
        espacio.setLongitud(dto.getLongitud());
        espacio.setLatitud(dto.getLatitud());
        espacio.setDescripcion(dto.getDescripcion());
        return espacio;
    }

    public static EspacioFisico toEntity(UpdateEspacioFisicoDTO dto) {
        EspacioFisico espacio = new EspacioFisico();
        espacio.setNombre(dto.getNombre());
        espacio.setCapacidad(dto.getCapacidad());
        espacio.setDescripcion(dto.getDescripcion());
        return espacio;
    }

    public static EspacioFisicoResponseDTO toDTO(EspacioFisico espacio) {
        EspacioFisicoResponseDTO dto = new EspacioFisicoResponseDTO();
        dto.setId(espacio.getId());
        dto.setNombre(espacio.getNombre());
        dto.setPropietario(espacio.getPropietario());
        dto.setCapacidad(espacio.getCapacidad());
        dto.setDireccion(espacio.getDireccion());
        dto.setLongitud(espacio.getLongitud());
        dto.setLatitud(espacio.getLatitud());
        dto.setDescripcion(espacio.getDescripcion());
        dto.setEstado(espacio.getEstado().toString());
        dto.setPuntosInteres(
                espacio.getPuntosInteres().stream().map(PuntoInteresMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public static ResumenEspacioFisicoResponseDTO toResumenDTO(EspacioFisico espacio) {
        ResumenEspacioFisicoResponseDTO dto = new ResumenEspacioFisicoResponseDTO();
        dto.setId(espacio.getId());
        dto.setNombre(espacio.getNombre());
        dto.setDescripcion(espacio.getDescripcion());
        dto.setCapacidad(espacio.getCapacidad());
        dto.setEstado(espacio.getEstado().toString());
        return dto;
    }
}