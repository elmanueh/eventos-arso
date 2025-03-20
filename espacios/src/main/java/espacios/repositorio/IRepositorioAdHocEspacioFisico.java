package espacios.repositorio;

import java.util.List;

import espacios.modelo.EspacioFisico;
import espacios.repositorio.core.IRepositorioString;

public interface IRepositorioAdHocEspacioFisico extends IRepositorioString<EspacioFisico> {

	List<EspacioFisico> getEspaciosFisicosByIds(List<String> ids);
}
