package eventos.communication;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Event<T> implements Serializable {

	private LocalDateTime fechaHora;
	private String idEntidad;
	private String tipoEvento;
	private T entidad;

	public Event() {
	}

	public Event(String idEntidad, String tipoEvento) {
		this.fechaHora = LocalDateTime.now();
		this.idEntidad = idEntidad;
		this.tipoEvento = tipoEvento;
		this.entidad = null;
	}

	public Event(String idEntidad, String tipoEvento, T entidad) {
		this(idEntidad, tipoEvento);
		this.entidad = entidad;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String nombreEvento) {
		this.tipoEvento = nombreEvento;
	}

	public T getEntidad() {
		return entidad;
	}

	public void setEntidad(T entidad) {
		this.entidad = entidad;
	}

	@Override
	public String toString() {
		return "Event [fechaHora=" + fechaHora + ", idEntidad=" + idEntidad + ", tipoEvento=" + tipoEvento
				+ ", entidad=" + entidad + "]";
	}

}
