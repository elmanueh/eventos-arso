package eventos.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.NoRepositoryBean;

import eventos.modelo.Evento;

@NoRepositoryBean
public interface RepositorioEventos extends PagingAndSortingRepository<Evento, String> {

	Page<Evento> getEventosDelMesPaginados(int mes, int año, Pageable pageable);
}
