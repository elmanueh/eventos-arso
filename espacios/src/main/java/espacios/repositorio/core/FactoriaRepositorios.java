package espacios.repositorio.core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import espacios.utils.PropertiesReader;

public class FactoriaRepositorios {

	private static final String PROPERTIES = "repositorios.properties";

	@SuppressWarnings("unchecked")
	public static <T, K, R extends IRepositorio<T, K>> R getRepositorio(Class<?> entidad) {

		try {
			PropertiesReader properties = new PropertiesReader(PROPERTIES);
			String clase = properties.getProperty(entidad.getName());
			return (R) Class.forName(clase).getConstructor().newInstance();
		} catch (IOException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException
				| InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
			throw new RuntimeException("No se ha podido obtener el repositorio para la entidad: " + entidad.getName());
		}

	}

}
