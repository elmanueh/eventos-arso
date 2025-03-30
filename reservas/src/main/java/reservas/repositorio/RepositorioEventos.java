package reservas.repositorio;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import reservas.modelo.Evento;

@NoRepositoryBean
public interface RepositorioEventos extends CrudRepository<Evento, UUID> {

}
