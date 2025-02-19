package espacios.servicio;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import espacios.modelo.EspacioFisico;
import espacios.modelo.PuntoInteres;
import espacios.repositorio.EntidadNoEncontrada;
import espacios.repositorio.FactoriaRepositorios;
import espacios.repositorio.IRepositorioAdHocEspacioFisico;
import espacios.repositorio.RepositorioException;

public class ServicioEspacios implements IServicioEspacios {

	private IRepositorioAdHocEspacioFisico repositorioEspacioFisico;

	public ServicioEspacios() {
		repositorioEspacioFisico = FactoriaRepositorios.getRepositorio(EspacioFisico.class);
	}

	@Override
	public EspacioFisico recuperarEspacioFisico(String idEspacioFisico)
			throws RepositorioException, EntidadNoEncontrada {
		return repositorioEspacioFisico.getById(idEspacioFisico);
	}

	@Override
	public String altaEspacioFisico(String nombre, String propietario, int capacidad, String direccionPostal,
			double latitud, double longidud, String descripcion) throws RepositorioException {

		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("El nombre del espacio físico no puede ser nulo o vacío.");
		if (propietario == null || propietario.isEmpty())
			throw new IllegalArgumentException("El propietario del espacio físico no puede ser nulo o vacío.");
		if (capacidad <= 0)
			throw new IllegalArgumentException("La capacidad del espacio físico debe ser mayor que 0.");
		if (direccionPostal == null || direccionPostal.isEmpty())
			throw new IllegalArgumentException("La dirección postal del espacio físico no puede ser nula o vacía.");
		if (latitud < -90 || latitud > 90)
			throw new IllegalArgumentException("La latitud del espacio físico debe estar entre -90 y 90.");
		if (longidud < -180 || longidud > 180)
			throw new IllegalArgumentException("La longitud del espacio físico debe estar entre -180 y 180.");
		if (descripcion == null || descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del espacio físico no puede ser nula o vacía.");

		EspacioFisico espacio = new EspacioFisico(nombre, propietario, capacidad, direccionPostal, latitud, longidud,
				descripcion);

		try {
			String id = repositorioEspacioFisico.add(espacio);
			return id;
		} catch (RepositorioException e) {
			throw new RepositorioException("Error al dar de alta el espacio físico con nombre " + nombre + ".");
		}
	}

	@Override
	public void asignarPuntosDeInteres(String idEspacioFisico, LinkedList<PuntoInteres> puntosInteres)
			throws RepositorioException, EntidadNoEncontrada {

		if (idEspacioFisico == null || idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo o vacío.");
		if (puntosInteres == null || puntosInteres.isEmpty())
			throw new IllegalArgumentException("La lista de puntos de interés no puede ser nula o vacía.");

		try {
			EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);
			espacioFisico.setPuntosInteres(puntosInteres);
			repositorioEspacioFisico.update(espacioFisico);
		} catch (RepositorioException e) {
			throw new RepositorioException(
					"Error al asignar los puntos de interés al espacio fisico con id " + idEspacioFisico + ".");
		} catch (EntidadNoEncontrada e) {
			throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id " + idEspacioFisico + ".");
		}
	}

	@Override
	public void modificarEspacioFisico(String idEspacioFisico, String nombre, int capacidad, String descripcion)
			throws RepositorioException, EntidadNoEncontrada {

		if (idEspacioFisico == null || idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo o vacío.");
		if (nombre != null && nombre.isEmpty())
			throw new IllegalArgumentException("El nombre del espacio físico no puede ser vacío.");
		if (capacidad == 0 && capacidad < -1)
			throw new IllegalArgumentException("La capacidad del espacio físico debe ser mayor que 0.");
		if (descripcion != null && descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del espacio físico no puede ser vacía.");

		try {
			EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);

			if (nombre != null)
				espacioFisico.setNombre(nombre);
			if (capacidad != -1)
				espacioFisico.setCapacidad(capacidad);
			if (descripcion != null)
				espacioFisico.setDescripcion(descripcion);

			repositorioEspacioFisico.update(espacioFisico);
		} catch (RepositorioException e) {
			throw new RepositorioException("Error al modificar el espacio físico con id " + idEspacioFisico + ".");
		} catch (EntidadNoEncontrada e) {
			throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id " + idEspacioFisico + ".");
		}
	}

	@Override
	public void bajaEspacioFisico(String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada {

		if (idEspacioFisico == null || idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo o vacío.");

		if (repositorioEspacioFisico.isAlgunaOcupacion(idEspacioFisico)) {
			try {
				EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);
				espacioFisico.cerrar();
				repositorioEspacioFisico.update(espacioFisico);
			} catch (RepositorioException e) {
				throw new RepositorioException(
						"Error al dar de baja el espacio físico con id " + idEspacioFisico + ".");
			} catch (EntidadNoEncontrada e) {
				throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id " + idEspacioFisico + ".");
			}
		}
	}

	@Override
	public void activarEspacioFisico(String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada {

		if (idEspacioFisico == null || idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo o vacío.");

		try {
			EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);
			espacioFisico.activar();
			repositorioEspacioFisico.update(espacioFisico);
		} catch (RepositorioException e) {
			throw new RepositorioException("Error al activar el espacio físico con id " + idEspacioFisico + ".");
		} catch (EntidadNoEncontrada e) {
			throw new EntidadNoEncontrada("Error al encontrar el espacio físico con id " + idEspacioFisico + ".");
		}
	}

	@Override
	public List<EspacioFisico> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidad) throws RepositorioException {

		if (fechaInicio == null)
			throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
		if (fechaFin == null)
			throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
		if (capacidad <= 0)
			throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");

		// return repositorioEspacioFisico.getEspaciosFisicoLibres(fechaInicio,
		// fechaFin, capacidad);
		// Por ahora devolver todos, proximamente nos comunicaremos con Eventos.
		return repositorioEspacioFisico.getAll();
	}

}
