package espacios.repositorio;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import espacios.modelo.EspacioFisico;
import espacios.repositorio.core.RepositorioJPA;
import espacios.utils.EntityManagerHelper;

public class RepositorioAdHocJPAEspacioFisico extends RepositorioJPA<EspacioFisico>
		implements IRepositorioAdHocEspacioFisico {

	@Override
	public Class<EspacioFisico> getClase() {
		return EspacioFisico.class;
	}

	@Override
	public List<EspacioFisico> getEspaciosFisicosByIds(List<UUID> ids) {
		EntityManager em = EntityManagerHelper.getEntityManager();

		String queryString = "SELECT e FROM EspacioFisico e WHERE e.id IN :ids";

		TypedQuery<EspacioFisico> typedQuery = em.createQuery(queryString, EspacioFisico.class);
		typedQuery.setParameter("ids", ids);

		List<EspacioFisico> resultado = typedQuery.getResultList();
		EntityManagerHelper.closeEntityManager();

		return resultado;
	}

}
