package espacios.repositorio;

import java.util.LinkedList;
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
		if (ids == null || ids.isEmpty()) {
			return new LinkedList<>();
		}

		EntityManager em = EntityManagerHelper.getEntityManager();

		String queryString = "SELECT e FROM EspacioFisico e WHERE e.id IN :ids";

		TypedQuery<EspacioFisico> typedQuery = em.createQuery(queryString, EspacioFisico.class);
		typedQuery.setParameter("ids", ids);

		List<EspacioFisico> resultado = typedQuery.getResultList();
		EntityManagerHelper.closeEntityManager();

		return resultado;
	}

	@Override
	public List<EspacioFisico> getEspaciosFisicosByPropietario(String propietario) {
		EntityManager em = EntityManagerHelper.getEntityManager();

		String queryString = "SELECT e FROM EspacioFisico e WHERE e.propietario = :propietario";

		TypedQuery<EspacioFisico> typedQuery = em.createQuery(queryString, EspacioFisico.class);
		typedQuery.setParameter("propietario", propietario);

		List<EspacioFisico> resultado = typedQuery.getResultList();
		EntityManagerHelper.closeEntityManager();

		return resultado;
	}

}
