package eventos.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.NoRepositoryBean;

import eventos.modelo.EspacioFisico;

@NoRepositoryBean
public interface RepositorioEspacios extends PagingAndSortingRepository<EspacioFisico, UUID> {
	List<UUID> getEspaciosFisicoLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas);

	int getNumeroOcupaciones(UUID idEspacioFisico);
}
