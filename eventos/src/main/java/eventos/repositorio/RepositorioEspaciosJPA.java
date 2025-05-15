package eventos.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eventos.modelo.EspacioFisico;

public interface RepositorioEspaciosJPA extends RepositorioEspacios, JpaRepository<EspacioFisico, UUID> {
	@Query("SELECT e.id FROM EspacioFisico e WHERE e.capacidad >= :capacidad AND "
			+ "e.cancelado = false AND "
			+ "e.id NOT IN (SELECT o.espacioFisico.id FROM Ocupacion o WHERE "
			+ "o.fechaFin <= :fechaFin AND o.fechaInicio >= :fechaInicio)")
	@Override
	List<UUID> getEspaciosFisicoLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad);

	@Query("SELECT COUNT(o.espacioFisico) FROM Ocupacion o WHERE o.espacioFisico.id = :idEspacioFisico AND o.fechaFin <= :fechaFin AND o.fechaInicio >= :fechaInicio")
	@Override
	int getNumeroOcupacionesPorRangoFechas(UUID idEspacioFisico, LocalDateTime fechaInicio, LocalDateTime fechaFin);

	@Query("SELECT COUNT(o.espacioFisico) FROM Ocupacion o WHERE o.espacioFisico.id = :idEspacioFisico")
	@Override
	int getNumeroOcupaciones(UUID idEspacioFisico);
}
