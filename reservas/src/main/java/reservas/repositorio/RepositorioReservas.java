package reservas.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.NoRepositoryBean;

import reservas.modelo.Reserva;

@NoRepositoryBean
public interface RepositorioReservas extends PagingAndSortingRepository<Reserva, String> {
	Page<Reserva> findByEventoId(String idEvento, Pageable pageable);
	
	Integer sumPlazasReservadasByEventoId(String idEvento);

}
