package eventos.servicio;

import java.util.Optional;
import java.util.UUID;

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

	public void crearEspacio(UUID idEspacio, boolean cancelado, int capacidad) {
		EspacioFisico espacio = new EspacioFisico();
		espacio.setId(idEspacio);
		espacio.setCancelado(cancelado);
		espacio.setCapacidad(capacidad);

		repositorioEspacios.save(espacio);
	}

	public void modificarEspacio(UUID idEspacio, int capacidad) {
		Optional<EspacioFisico> espacioOpt = repositorioEspacios.findById(idEspacio);

		if (!espacioOpt.isPresent())
			return;

		EspacioFisico espacio = espacioOpt.get();
		espacio.setCapacidad(capacidad);

		repositorioEspacios.save(espacio);
	}

	public void cambiarEstadoEspacio(UUID idEspacio, boolean isCancelado) {
		Optional<EspacioFisico> espacioOpt = repositorioEspacios.findById(idEspacio);

		if (!espacioOpt.isPresent())
			return;

		EspacioFisico espacio = espacioOpt.get();
		espacio.setCancelado(isCancelado);

		repositorioEspacios.save(espacio);
	}
}