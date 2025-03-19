package espacios.servicio.eventos;

import java.time.LocalDateTime;
import java.util.List;

import espacios.modelo.EspacioFisico;

public interface IServicioEventos {

	boolean isAlgunaOcupacion(String idEspacio);

	List<EspacioFisico> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad);
}