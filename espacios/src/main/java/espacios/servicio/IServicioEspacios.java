package espacios.servicio;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import espacios.modelo.EspacioFisico;
import espacios.modelo.PuntoInteres;
import espacios.repositorio.EntidadNoEncontrada;
import espacios.repositorio.RepositorioException;

public interface IServicioEspacios {

	String altaEspacioFisico(String nombre, String propietario, int capacidad, String direccionPostal, double latitud,
			double longidud,
			String descripcion) throws RepositorioException;

	void asignarPuntosDeInteres(String idEspacioFisico, LinkedList<PuntoInteres> puntosInteres)
			throws RepositorioException, EntidadNoEncontrada;

	void modificarEspacioFisico(String idEspacioFisico, String nombre, int capacidad, String descripcion)
			throws RepositorioException, EntidadNoEncontrada;

	void bajaEspacioFisico(String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada;

	void activarEspacioFisico(String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada;

	List<EspacioFisico> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidad)
			throws RepositorioException;
}