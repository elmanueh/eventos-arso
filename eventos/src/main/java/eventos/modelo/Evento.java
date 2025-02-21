package eventos.modelo;

import java.time.LocalDateTime;

public class Evento {

	private String id;
	private String nombre;
	private String descripcion;
	private String organizador;
	private int plazas;
	private boolean cancelado;
	private EventoCategoria categoria;
	private Ocupacion ocupacion;

	public Evento() {

	}

	public Evento(String nombre, String descripcion, String organizador, int plazas, EventoCategoria categoria,
			LocalDateTime fechaInicio,
			LocalDateTime fechaFin, EspacioFisico espacioFisico) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.organizador = organizador;
		this.plazas = plazas;
		this.cancelado = false;
		this.categoria = categoria;
		this.ocupacion = new Ocupacion(fechaInicio, fechaFin, espacioFisico);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrganizador() {
		return organizador;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public EventoCategoria getCategoria() {
		return categoria;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public boolean entreFechas(int mes, int año) {
		return ocupacion.entreFechas(mes, año);
	}

	public void setCancelado() {
		cancelado = true;
		ocupacion = null;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		ocupacion.setFechaInicio(fechaInicio);
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		ocupacion.setFechaFin(fechaFin);
	}

	public void setEspacioFisico(EspacioFisico espacioFisico) {
		ocupacion.setEspacioFisico(espacioFisico);
	}

	@Override
	public String toString() {
		return "Evento [Nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria + "]\n"
				+ ocupacion.toString() + "\n";
	}

}
