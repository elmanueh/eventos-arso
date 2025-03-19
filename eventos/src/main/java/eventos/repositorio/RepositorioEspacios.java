package eventos.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.springframework.data.repository.NoRepositoryBean;

import eventos.modelo.EspacioFisico;

@NoRepositoryBean
public interface RepositorioEspacios extends PagingAndSortingRepository<EspacioFisico, String> {
	LinkedList<EspacioFisico> getEspaciosFisicoLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int numPlazas);

	int getNumeroOcupaciones(String idEspacioFisico);
}
