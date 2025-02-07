package eventos.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import eventos.modelo.Evento;
import eventos.utils.EntityManagerHelper;

public class RepositorioAdHocJPAEvento extends RepositorioJPA<Evento> implements IRepositorioAdHocEvento {

	@Override
	public Class<Evento> getClase() {
		return Evento.class;
	}

	public List<Evento> getEventosDelMes(int mes, int año) {

		EntityManager em = EntityManagerHelper.getEntityManager();

		String queryString = "SELECT e FROM Evento e "
				+ "WHERE :mes BETWEEN EXTRACT(MONTH FROM e.ocupacion.fechaInicio) AND EXTRACT(MONTH FROM e.ocupacion.fechaFin) "
				+ "AND :año BETWEEN EXTRACT(YEAR FROM e.ocupacion.fechaInicio) AND EXTRACT(YEAR FROM e.ocupacion.fechaFin)";

		TypedQuery<Evento> typedQuery = em.createQuery(queryString, Evento.class);
		typedQuery.setParameter("mes", mes);
		typedQuery.setParameter("año", año);

		List<Evento> resultado = typedQuery.getResultList();
		EntityManagerHelper.closeEntityManager();

		return resultado;
	}
}
