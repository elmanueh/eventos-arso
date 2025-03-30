package reservas.repositorio;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.NoRepositoryBean;

import reservas.modelo.Reserva;

@NoRepositoryBean
public interface RepositorioReservas extends PagingAndSortingRepository<Reserva, UUID> {
	Page<Reserva> findByEventoId(UUID idEvento, Pageable pageable);

	Integer sumPlazasReservadasByEventoId(UUID idEvento);

}
