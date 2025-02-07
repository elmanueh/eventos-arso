package espacios.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import espacios.modelo.EspacioFisico;

public interface IRepositorioAdHocEspacioFisico extends IRepositorioString<EspacioFisico> {

	boolean isAlgunaOcupacion(String idEspacioFisico);

	List<EspacioFisico> getEspaciosFisicoLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad);
}
