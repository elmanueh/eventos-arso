package eventos.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import eventos.modelo.EspacioFisico;

@NoRepositoryBean
public interface RepositorioEspacios extends PagingAndSortingRepository<EspacioFisico, String> {
	List<String> getEspaciosFisicoLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas);

	int getNumeroOcupaciones(String idEspacioFisico);
}
