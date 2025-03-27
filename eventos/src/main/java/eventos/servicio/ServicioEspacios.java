package eventos.servicio;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eventos.modelo.EspacioFisico;
import eventos.repositorio.RepositorioEspacios;

@Service
@Transactional
public class ServicioEspacios implements IServicioEspacios {

	private final RepositorioEspacios repositorioEspacios;

	@Autowired
	public ServicioEspacios(RepositorioEspacios repositorioEspacios) {
		this.repositorioEspacios = repositorioEspacios;
	}

	public void crearEspacio(String idEspacio, String nombre, String propietario, String direccion, boolean cancelado,
			int capacidad) {
		EspacioFisico espacio = new EspacioFisico();
		espacio.setId(idEspacio);
		espacio.setNombre(nombre);
		espacio.setPropietario(propietario);
		espacio.setDireccion(direccion);
		espacio.setCancelado(cancelado);
		espacio.setCapacidad(capacidad);

		repositorioEspacios.save(espacio);
	}

	public void modificarEspacio(String idEspacio, String nombre, int capacidad) {
		Optional<EspacioFisico> espacioOpt = repositorioEspacios.findById(idEspacio);

		if (!espacioOpt.isPresent())
			return;

		EspacioFisico espacio = espacioOpt.get();
		espacio.setNombre(nombre);
		espacio.setCapacidad(capacidad);

		repositorioEspacios.save(espacio);
	}

	public void cambiarEstadoEspacio(String idEspacio, boolean isCancelado) {
		Optional<EspacioFisico> espacioOpt = repositorioEspacios.findById(idEspacio);

		if (!espacioOpt.isPresent())
			return;

		EspacioFisico espacio = espacioOpt.get();
		espacio.setCancelado(isCancelado);

		repositorioEspacios.save(espacio);
	}
}