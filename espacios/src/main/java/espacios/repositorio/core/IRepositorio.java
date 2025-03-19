package espacios.repositorio.core;

import java.util.List;

import espacios.repositorio.exception.EntidadNoEncontrada;
import espacios.repositorio.exception.RepositorioException;

public interface IRepositorio<T, K> {

	K add(T entity) throws RepositorioException;

	void update(T entity) throws RepositorioException, EntidadNoEncontrada;

	void delete(T entity) throws RepositorioException, EntidadNoEncontrada;

	T getById(K id) throws RepositorioException, EntidadNoEncontrada;

	List<T> getAll() throws RepositorioException;

	List<K> getIds() throws RepositorioException;
}
