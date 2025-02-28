package reservas.servicio;

import java.util.List;

import reservas.repositorio.EntidadNoEncontrada;
import reservas.modelo.Reserva;

public interface IServicioReservas {
	
	String reservar(String idEvento, String idUsuario, int numPlazas) throws EntidadNoEncontrada;
	
	Reserva recuperarReserva(String idReserva) throws EntidadNoEncontrada;
	
	List<Reserva> recuperarTodasReservas(String idEvento) throws EntidadNoEncontrada;
	
}
