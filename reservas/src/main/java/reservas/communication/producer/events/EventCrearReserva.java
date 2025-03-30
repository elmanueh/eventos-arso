package reservas.communication.producer.events;

import java.util.UUID;

import reservas.communication.RabbitEvent;

public class EventCrearReserva extends RabbitEvent {

	private UUID idUsuario;
	private int plazasReservadas;
	private boolean cancelada;
	private UUID idEvento;

	public EventCrearReserva() {
	}

	public UUID getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getPlazasReservadas() {
		return plazasReservadas;
	}

	public void setPlazasReservadas(int plazasReservadas) {
		this.plazasReservadas = plazasReservadas;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public UUID getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(UUID idEvento) {
		this.idEvento = idEvento;
	}

}
