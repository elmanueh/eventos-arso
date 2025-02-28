package reservas.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import reservas.modelo.Reserva;

@NoRepositoryBean
public interface RepositorioReservas extends CrudRepository<Reserva, String> {
	List<Reserva> findByEventoId(String idEvento);

}
