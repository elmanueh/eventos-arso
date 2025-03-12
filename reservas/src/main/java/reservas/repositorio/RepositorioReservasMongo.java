package reservas.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import reservas.modelo.Reserva;

public interface RepositorioReservasMongo extends RepositorioReservas, MongoRepository<Reserva, String> {

    List<Reserva> findByEventoId(String idEvento);

    Page<Reserva> findByEventoId(String idEvento, Pageable pageable);
}
