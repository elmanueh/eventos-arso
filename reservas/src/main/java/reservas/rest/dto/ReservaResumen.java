package reservas.rest.dto;

public class ReservaResumen {
	private String id;
	private String idUsuario;
    private int plazasReservadas;
    private boolean cancelada;
    private boolean evento;

	public ReservaResumen() {
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
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

	public boolean isEvento() {
		return evento;
	}

	public void setEvento(boolean evento) {
		this.evento = evento;
	}

	

}
