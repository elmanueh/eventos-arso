package eventos.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.EspacioFisico;

public interface RepositorioEspaciosJPA extends RepositorioEspacios, JpaRepository<EspacioFisico, String> {
	@Query("SELECT e.id FROM EspacioFisico e WHERE e.capacidad >= :capacidad AND "
			+ "e.cancelado = false AND "
			+ "e.id NOT IN (SELECT o.espacioFisico.id FROM Ocupacion o WHERE "
			+ "o.fechaFin <= :fechaFin AND o.fechaInicio >= :fechaInicio)")
	List<String> getEspaciosFisicoLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad);

	@Query("SELECT COUNT(o.espacioFisico) FROM Ocupacion o WHERE o.espacioFisico.id = :idEspacioFisico"
			+ " AND o.fechaInicio <= CURRENT_TIMESTAMP AND o.fechaFin >= CURRENT_TIMESTAMP")
	int getNumeroOcupaciones(String idEspacioFisico);
}
