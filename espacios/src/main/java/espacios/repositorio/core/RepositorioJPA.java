package espacios.repositorio.core;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import espacios.repositorio.exception.EntidadNoEncontrada;
import espacios.repositorio.exception.RepositorioException;
import espacios.utils.EntityManagerHelper;

public abstract class RepositorioJPA<T extends Identificable> implements IRepositorioUUID<T> {

	public abstract Class<T> getClase();

	@Override
	public UUID add(T entity) throws RepositorioException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new RepositorioException("Error al guardar la entidad con id " + entity.getId(), e);
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			EntityManagerHelper.closeEntityManager();
		}
		return entity.getId();
	}

	@Override
	public void update(T entity) throws RepositorioException, EntidadNoEncontrada {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			T instance = em.find(getClase(), entity.getId());
			if (instance == null) {
				throw new RepositorioException(
						"La entidad con id " + entity.getId() + " no existe en el repositorio");
			}
			entity = em.merge(entity);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			throw new RepositorioException("Error al actualizar la entidad con id " + entity.getId(), e);
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			EntityManagerHelper.closeEntityManager();
		}
	}

	@Override
	public void delete(T entity) throws RepositorioException, EntidadNoEncontrada {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			T instance = em.find(getClase(), entity.getId());

			if (instance == null) {
				throw new EntidadNoEncontrada("La entidad con id " + entity.getId() + " no existe en el repositorio");
			}
			em.remove(instance);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			throw new RepositorioException("Error al borrar la entidad con id " + entity.getId(), e);
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			EntityManagerHelper.closeEntityManager();
		}

	}

	@Override
	public T getById(UUID id) throws RepositorioException, EntidadNoEncontrada {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			T instance = em.find(getClase(), id);

			if (instance == null) {
				throw new EntidadNoEncontrada("La entidad con id " + id + " no existe en el repositorio");
			} else {
				em.refresh(instance);
			}
			return instance;
		} catch (RuntimeException e) {
			throw new RepositorioException("Error al recuperar la entidad con id " + id, e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() throws RepositorioException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			final String queryString = " SELECT t FROM " + getClase().getSimpleName() + " t ";

			Query query = em.createQuery(queryString);

			query.setHint(QueryHints.REFRESH, HintValues.TRUE);

			return query.getResultList();
		} catch (Exception e) {
			throw new RepositorioException(
					"Error al buscar todas las entidades de las instancias de " + getClase().getSimpleName(), e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UUID> getIds() throws RepositorioException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			final String queryString = " SELECT t.id FROM " + getClase().getSimpleName() + " t ";

			Query query = em.createQuery(queryString);

			query.setHint(QueryHints.REFRESH, HintValues.TRUE);

			return query.getResultList();
		} catch (Exception e) {
			throw new RepositorioException(
					"Error al buscar todos los ids de las instancias de " + getClase().getSimpleName(), e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}
}
