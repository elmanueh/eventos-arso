package reservas.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import reservas.modelo.Reserva;

public interface RepositorioReservasMongo extends RepositorioReservas, MongoRepository<Reserva, String> {
    Page<Reserva> findByEventoId(String idEvento, Pageable pageable);

}
