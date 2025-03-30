package reservas.repositorio;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import reservas.modelo.Reserva;

public interface RepositorioReservasMongo extends RepositorioReservas, MongoRepository<Reserva, UUID> {
    Page<Reserva> findByEventoId(UUID idEvento, Pageable pageable);

    @Aggregation(pipeline = {
            "{ $match: { 'eventoId': ?0 } }",
            "{ $group: { _id: null, totalPlazas: { $sum: '$plazasReservadas' } } }",
            "{ $project: { _id: 0, totalPlazas: '$totalPlazas' } }"
    })
    Integer sumPlazasReservadasByEventoId(UUID idEvento);
}
