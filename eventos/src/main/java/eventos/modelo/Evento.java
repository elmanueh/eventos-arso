package eventos.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Lob
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "organizador")
	private String organizador;
	
	@Column(name = "plazas")
	private int numPlazas;
	
	@Column(name = "cancelado")
	private boolean cancelado;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoria")
	private EventoCategoria categoria;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idOcupacion")
	private Ocupacion ocupacion;


	public Evento() {

	}

	public Evento(String nombre, String descripcion, String organizador, int numPlazas, EventoCategoria categoria,
			LocalDateTime fechaInicio,
			LocalDateTime fechaFin, EspacioFisico espacioFisico) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.organizador = organizador;
		this.numPlazas = numPlazas;
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

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
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
				+ ocupacion + "\n";
	}

}
