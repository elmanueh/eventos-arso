package reservas.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservas.modelo.Evento;
import reservas.modelo.Reserva;
import reservas.repositorio.EntidadNoEncontrada;
import reservas.repositorio.RepositorioEventos;
import reservas.repositorio.RepositorioReservas;

@Service
@Transactional
public class ServicioReservas implements IServicioReservas {

	private RepositorioReservas repositorioReservas;
	private RepositorioEventos repositorioEventos;

	@Autowired
	public ServicioReservas(RepositorioReservas repositorioReservas, RepositorioEventos repositorioEventos) {
		this.repositorioReservas = repositorioReservas;
		this.repositorioEventos = repositorioEventos;
	}

	// USUARIO
	@Override
	public String reservar(String idEvento, String idUsuario, int numPlazas) throws EntidadNoEncontrada {
		Optional<Evento> eventoOpt = repositorioEventos.findById(idEvento);

		if (!eventoOpt.isPresent()) {
			throw new EntidadNoEncontrada("No existe evento con id: " + idEvento);
		}

		Evento evento = eventoOpt.get();

		if (evento.isCancelado())
			throw new IllegalArgumentException("El evento con id " + idEvento + " está cancelado.");

		if (evento.getPlazasDisponibles() < numPlazas)
			throw new IllegalArgumentException(
					"El número de plazas supera la capacidad del evento con id " + idEvento + ".");

		// Crear reserva
		Reserva nuevaReserva = new Reserva();
		nuevaReserva.setEvento(evento);
		nuevaReserva.setIdUsuario(idUsuario);
		nuevaReserva.setPlazasReservadas(numPlazas);

		repositorioReservas.save(nuevaReserva);

		// TODO: esta bien lo siguiente??
		// Actualizar plazas en el evento
		evento.reservarPlazas(numPlazas);
		evento.addReserva(nuevaReserva);

		repositorioEventos.save(evento);

		return nuevaReserva.getId();
	}

	// USUARIO
	@Override
	public Reserva recuperarReserva(String idReserva) throws EntidadNoEncontrada {
		if (idReserva == null || idReserva.isEmpty())
			throw new IllegalArgumentException("id: no debe ser nulo ni vacio");

		Optional<Reserva> resultado = repositorioReservas.findById(idReserva);

		if (resultado.isPresent() == false)
			throw new EntidadNoEncontrada("No existe encuesta con id: " + idReserva);
		else
			return resultado.get();
	}

	// GESTOR_EVENTOS
	@Override
	public List<Reserva> recuperarTodasReservas(String idEvento) throws EntidadNoEncontrada {
		if (idEvento == null || idEvento.isEmpty()) {
			throw new IllegalArgumentException("idEvento: no debe ser nulo ni vacío");
		}

		List<Reserva> reservas = repositorioReservas.findByEventoId(idEvento);

		return reservas;
	}

}