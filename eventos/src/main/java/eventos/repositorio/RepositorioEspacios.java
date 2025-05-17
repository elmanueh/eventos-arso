package eventos.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import eventos.modelo.EspacioFisico;

@NoRepositoryBean
public interface RepositorioEspacios extends PagingAndSortingRepository<EspacioFisico, UUID> {
	List<UUID> getEspaciosFisicoLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas);

	int getNumeroOcupacionesPorRangoFechas(UUID idEspacioFisico, LocalDateTime fechaInicio, LocalDateTime fechaFin);

	int getNumeroOcupacionesPorRangoFechasEnEvento(UUID idEspacioFisico, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			UUID idEvento);

	int getNumeroOcupaciones(UUID idEspacioFisico);
}
