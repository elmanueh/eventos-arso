package eventos.repositorio;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.Evento;

public interface RepositorioEventosJPA extends RepositorioEventos, JpaRepository<Evento, UUID> {

	@Query("SELECT e FROM Evento e "
			+ "WHERE :mes BETWEEN EXTRACT(MONTH FROM e.ocupacion.fechaInicio) AND EXTRACT(MONTH FROM e.ocupacion.fechaFin) "
			+ "AND :año BETWEEN EXTRACT(YEAR FROM e.ocupacion.fechaInicio) AND EXTRACT(YEAR FROM e.ocupacion.fechaFin)")
	Page<Evento> getEventosDelMesPaginados(int mes, int año, Pageable pageable);
	
	@Query("SELECT COALESCE(MAX(e.numPlazas), 0) FROM Evento e "
			+ "WHERE e.cancelado = false "
			+ "AND e.ocupacion.espacioFisico.id = :idEspacioFisico")
    Integer getMaxNumPlazasByEspacioFisico(UUID idEspacioFisico);

}
