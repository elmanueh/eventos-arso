package eventos.repositorio;

import java.util.List;

import eventos.modelo.Evento;

public interface IRepositorioAdHocEvento extends IRepositorioString<Evento> {

	List<Evento> getEventosDelMes(int mes, int año);
}
