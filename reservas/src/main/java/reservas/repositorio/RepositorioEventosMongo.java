package reservas.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import reservas.modelo.Evento;

public interface RepositorioEventosMongo extends RepositorioEventos, MongoRepository<Evento, String> {

}
