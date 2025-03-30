package espacios.repositorio;

import java.util.List;
import java.util.UUID;

import espacios.modelo.EspacioFisico;
import espacios.repositorio.core.IRepositorioString;
import espacios.repositorio.core.IRepositorioUUID;

public interface IRepositorioAdHocEspacioFisico extends IRepositorioUUID<EspacioFisico> {

	List<EspacioFisico> getEspaciosFisicosByIds(List<UUID> ids);
}
