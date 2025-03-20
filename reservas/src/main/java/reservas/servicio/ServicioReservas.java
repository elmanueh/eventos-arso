package reservas.servicio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservas.modelo.Evento;
import reservas.modelo.Reserva;
import reservas.repositorio.RepositorioEventos;
import reservas.repositorio.RepositorioReservas;
import reservas.repositorio.exception.EntidadNoEncontrada;
import reservas.rest.dto.ReservaResumen;
import reservas.rest.mapper.ReservaMapper;

@Service
@Transactional
public class ServicioReservas implements IServicioReservas {

	private final RepositorioReservas repositorioReservas;
	private final RepositorioEventos repositorioEventos;

	@Autowired
	public ServicioReservas(RepositorioReservas repositorioReservas, RepositorioEventos repositorioEventos) {
		this.repositorioReservas = repositorioReservas;
		this.repositorioEventos = repositorioEventos;
	}

	// USUARIO
	@Override
	public String reservar(String idEvento, String idUsuario, int numPlazas) throws EntidadNoEncontrada {
		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("idEvento: no debe ser nulo ni vacío");
		if (idUsuario == null || idUsuario.isEmpty())
			throw new IllegalArgumentException("idUsuario: no debe ser nulo ni vacío");
		if (numPlazas <= 0)
			throw new IllegalArgumentException("numPlazas: debe ser mayor que 0");

		Optional<Evento> eventoOpt = repositorioEventos.findById(idEvento);

		if (!eventoOpt.isPresent())
			throw new EntidadNoEncontrada("No existe evento con id: " + idEvento);

		Evento evento = eventoOpt.get();

		if (evento.isCancelado())
			throw new IllegalStateException("El evento con id " + idEvento + " está cancelado.");

		if (evento.getPlazasDisponibles() < numPlazas)
			throw new IllegalStateException(
					"El número de plazas supera la capacidad del evento con id " + idEvento + ".");

		Reserva nuevaReserva = new Reserva();
		nuevaReserva.setEvento(evento);
		nuevaReserva.setIdUsuario(idUsuario);
		nuevaReserva.setPlazasReservadas(numPlazas);

		repositorioReservas.save(nuevaReserva);

		evento.reservarPlazas(numPlazas);
		evento.addReserva(nuevaReserva);

		repositorioEventos.save(evento);

		return nuevaReserva.getId();
	}

	// USUARIO
	@Override
	public Reserva recuperarReserva(String idReserva) throws EntidadNoEncontrada {
		if (idReserva == null || idReserva.isEmpty())
			throw new IllegalArgumentException("idReserva: no debe ser nulo ni vacio");

		Optional<Reserva> reservaOpt = repositorioReservas.findById(idReserva);

		if (!reservaOpt.isPresent())
			throw new EntidadNoEncontrada("No existe encuesta con id: " + idReserva);
		return reservaOpt.get();
	}

	// GESTOR_EVENTOS
	@Override
	public Page<ReservaResumen> recuperarTodasReservas(String idEvento, Pageable pageable) throws EntidadNoEncontrada {
		if (idEvento == null || idEvento.isEmpty())
			throw new IllegalArgumentException("idEvento: no debe ser nulo ni vacío");

		Page<ReservaResumen> reservas = repositorioReservas.findByEventoId(idEvento, pageable)
				.map(ReservaMapper::toResumen);
		return reservas;
	}

}