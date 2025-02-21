package eventos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import eventos.modelo.Evento;

@NoRepositoryBean
public interface RepositorioEventos extends CrudRepository<Evento, String> {

}
