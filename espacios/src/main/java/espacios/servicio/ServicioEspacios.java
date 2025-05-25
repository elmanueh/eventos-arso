package espacios.servicio;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import espacios.communication.producer.IEventProducer;
import espacios.modelo.EspacioFisico;
import espacios.modelo.PuntoInteres;
import espacios.repositorio.IRepositorioAdHocEspacioFisico;
import espacios.repositorio.core.FactoriaRepositorios;
import espacios.repositorio.exception.EntidadNoEncontrada;
import espacios.repositorio.exception.RepositorioException;
import espacios.servicio.core.FactoriaServicios;
import espacios.servicio.eventos.IServicioEventosAPI;
import espacios.servicio.eventos.exception.ServicioEventosException;

public class ServicioEspacios implements IServicioEspacios {

	private final IRepositorioAdHocEspacioFisico repositorioEspacioFisico;
	private final IServicioEventosAPI servicioEventosAPI;
	private final IEventProducer eventProducer;

	public ServicioEspacios() {
		repositorioEspacioFisico = FactoriaRepositorios.getRepositorio(EspacioFisico.class);
		servicioEventosAPI = FactoriaServicios.getServicio(IServicioEventosAPI.class);
		eventProducer = FactoriaServicios.getServicio(IEventProducer.class);
	}

	@Override
	public EspacioFisico recuperarEspacioFisico(UUID idEspacioFisico)
			throws RepositorioException, EntidadNoEncontrada {

		if (idEspacioFisico == null)
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo.");

		return repositorioEspacioFisico.getById(idEspacioFisico);
	}

	@Override
	public UUID altaEspacioFisico(String nombre, String propietario, int capacidad, String direccionPostal,
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

		UUID id = repositorioEspacioFisico.add(espacio);
		eventProducer.publicarEspacioCreado(id, espacio);

		return id;
	}

	@Override
	public void asignarPuntosDeInteres(UUID idEspacioFisico, LinkedList<PuntoInteres> puntosInteres)
			throws RepositorioException, EntidadNoEncontrada {

		if (idEspacioFisico == null)
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo.");
		if (puntosInteres == null || puntosInteres.isEmpty())
			throw new IllegalArgumentException("La lista de puntos de interés no puede ser nula o vacía.");

		EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);
		espacioFisico.setPuntosInteres(puntosInteres);
		repositorioEspacioFisico.update(espacioFisico);
	}

	@Override
	public void modificarEspacioFisico(UUID idEspacioFisico, String nombre, int capacidad, String descripcion)
			throws RepositorioException, EntidadNoEncontrada, ServicioEventosException, IllegalStateException {

		if (idEspacioFisico == null)
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo.");
		if (nombre != null && nombre.isEmpty())
			throw new IllegalArgumentException("El nombre del espacio físico no puede ser vacío.");
		if (capacidad <= -1)
			throw new IllegalArgumentException("La capacidad del espacio físico debe ser mayor que 0.");
		if (descripcion != null && descripcion.isEmpty())
			throw new IllegalArgumentException("La descripción del espacio físico no puede ser vacía.");

		EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);

		if (nombre != null)
			espacioFisico.setNombre(nombre);
		if (capacidad != 0) {
			int numPlazasMax = servicioEventosAPI.validarCapacidad(idEspacioFisico);
			if (numPlazasMax > capacidad) {
				throw new IllegalStateException("La capacidad del espacio físico con id " + idEspacioFisico
						+ " no puede ser menor al número de plazas mayor de un evento.");
			}
			espacioFisico.setCapacidad(capacidad);
		}
		if (descripcion != null)
			espacioFisico.setDescripcion(descripcion);

		repositorioEspacioFisico.update(espacioFisico);
		eventProducer.publicarEspacioModificado(espacioFisico.getId(), espacioFisico);
	}

	@Override
	public void bajaEspacioFisico(UUID idEspacioFisico)
			throws RepositorioException, EntidadNoEncontrada, ServicioEventosException {

		if (idEspacioFisico == null)
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo.");

		if (servicioEventosAPI.isAlgunaOcupacion(idEspacioFisico)) {
			throw new IllegalStateException("El espacio físico con id " + idEspacioFisico
					+ " no puede ser dado de baja porque tiene eventos activos.");
		}

		EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);
		espacioFisico.cerrar();
		repositorioEspacioFisico.update(espacioFisico);
		eventProducer.publicarEspacioEstadoModificado(idEspacioFisico, true);
	}

	@Override
	public void activarEspacioFisico(UUID idEspacioFisico) throws RepositorioException, EntidadNoEncontrada {

		if (idEspacioFisico == null)
			throw new IllegalArgumentException("El id del espacio físico no puede ser nulo.");

		EspacioFisico espacioFisico = repositorioEspacioFisico.getById(idEspacioFisico);
		espacioFisico.activar();
		repositorioEspacioFisico.update(espacioFisico);
		eventProducer.publicarEspacioEstadoModificado(idEspacioFisico, false);
	}

	@Override
	public List<EspacioFisico> buscarEspaciosFisicosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidad) throws RepositorioException, ServicioEventosException {

		if (fechaInicio == null)
			throw new IllegalArgumentException("La fecha de inicio no puede ser nula.");
		if (fechaFin == null)
			throw new IllegalArgumentException("La fecha de fin no puede ser nula.");
		if (capacidad <= 0)
			throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");

		List<UUID> espaciosFisicosIds = servicioEventosAPI.buscarEspaciosFisicosLibres(fechaInicio, fechaFin,
				capacidad);

		return repositorioEspacioFisico.getEspaciosFisicosByIds(espaciosFisicosIds);
	}

	@Override
	public List<EspacioFisico> recuperarEspaciosPorPropietario(String propietario) {
		if (propietario == null)
			throw new IllegalArgumentException("El propietario no puede ser nulo.");

		return repositorioEspacioFisico.getEspaciosFisicosByPropietario(propietario);
	}

	@Override
	public List<EspacioFisico> recuperarTodosLosEspacios() throws RepositorioException {
		return repositorioEspacioFisico.getAll();
	}

}
