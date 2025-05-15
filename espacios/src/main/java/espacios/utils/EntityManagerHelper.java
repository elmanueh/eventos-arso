package espacios.utils;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.github.cdimascio.dotenv.Dotenv;

public class EntityManagerHelper {
	private static final EntityManagerFactory entityManagerFactory;

	private static final ThreadLocal<EntityManager> entityManagerHolder;

	static {
		Dotenv dotenv = Dotenv.load();

		Map<String, String> props = new HashMap<>();
		props.put("javax.persistence.jdbc.user", dotenv.get("MYSQL_USERNAME"));
		props.put("javax.persistence.jdbc.password", dotenv.get("MYSQL_PASSWORD"));
		props.put("javax.persistence.jdbc.url", dotenv.get("MYSQL_URL_ESPACIOS"));

		entityManagerFactory = Persistence.createEntityManagerFactory("espacios", props);

		entityManagerHolder = new ThreadLocal<>();
	}

	public static EntityManager getEntityManager() {

		EntityManager entityManager = entityManagerHolder.get();

		if (entityManager == null || !entityManager.isOpen()) {

			entityManager = entityManagerFactory.createEntityManager();
			entityManagerHolder.set(entityManager);

		}

		return entityManager;

	}

	public static void closeEntityManager() {

		EntityManager entityManager = entityManagerHolder.get();

		if (entityManager != null) {

			entityManagerHolder.set(null);

			entityManager.close();

		}

	}
}
