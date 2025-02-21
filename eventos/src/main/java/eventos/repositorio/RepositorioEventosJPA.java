package eventos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import eventos.modelo.Evento;

public interface RepositorioEventosJPA extends RepositorioEventos, JpaRepository<Evento, String> {

}
