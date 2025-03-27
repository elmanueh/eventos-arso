package reservas.servicio;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservas.modelo.Evento;
import reservas.repositorio.RepositorioEventos;

@Service
@Transactional
public class ServicioEventos implements IServicioEventos {

	private final RepositorioEventos repositorioEventos;

	@Autowired
	public ServicioEventos(RepositorioEventos repositorioEventos) {
		this.repositorioEventos = repositorioEventos;
	}

	public void crearEvento(String idEvento, int capacidad, boolean cancelado) {
		Evento evento = new Evento();
		evento.setId(idEvento);
		evento.setPlazasDisponibles(capacidad);
		evento.setCancelado(cancelado);
		repositorioEventos.save(evento);
	}

	@Override
	public void modificarEvento(String idEvento, int capacidad) {
		Optional<Evento> eventoOpt = repositorioEventos.findById(idEvento);

		if (!eventoOpt.isPresent())
			return;

		Evento evento = eventoOpt.get();
		System.out.println(capacidad);
		evento.setPlazasDisponibles(capacidad);
		repositorioEventos.save(evento);
	}

	@Override
	public void cancelarEvento(String idEvento) {
		Optional<Evento> eventoOpt = repositorioEventos.findById(idEvento);

		if (!eventoOpt.isPresent())
			return;

		Evento evento = eventoOpt.get();
		evento.setCancelado(true);

		repositorioEventos.save(evento);
	}

}