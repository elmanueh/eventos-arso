package espacios.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import espacios.repositorio.core.Identificable;
import espacios.utils.UUIDConverter;

@Entity
@Table(name = "espacioFisico")
public class EspacioFisico implements Identificable {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "propietario")
	private String propietario;

	@Column(name = "capacidad")
	private int capacidad;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "longitud")
	private double longitud;

	@Column(name = "latitud")
	private double latitud;

	@Lob
	@Column(name = "descripcion")
	private String descripcion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EspacioFisicoEstado estado;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "espacioFisico_puntoInteres", joinColumns = @JoinColumn(name = "idEspacioFisico"), inverseJoinColumns = @JoinColumn(name = "idPuntosInteres"))
	private List<PuntoInteres> puntosInteres;

	public EspacioFisico() {

	}

	public EspacioFisico(String nombre, String propietario, int capacidad, String direccion, double latitud,
			double longitud, String descripcion) {
		this.nombre = nombre;
		this.propietario = propietario;
		this.capacidad = capacidad;
		this.direccion = direccion;
		this.longitud = longitud;
		this.latitud = latitud;
		this.descripcion = descripcion;

		this.estado = EspacioFisicoEstado.ACTIVO;
		this.puntosInteres = new LinkedList<PuntoInteres>();
	}

	@PrePersist
	public void generateUUID() {
		if (id == null) {
			id = UUID.randomUUID();
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public List<PuntoInteres> getPuntosInteres() {
		return new LinkedList<PuntoInteres>(puntosInteres);
	}

	public void setPuntosInteres(LinkedList<PuntoInteres> puntosInteres) {
		this.puntosInteres.addAll(puntosInteres);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public EspacioFisicoEstado getEstado() {
		return estado;
	}

	public boolean isCancelado() {
		return estado == EspacioFisicoEstado.CERRADO_TEMPORALMENTE;
	}

	public void activar() {
		this.estado = EspacioFisicoEstado.ACTIVO;
	}

	public void cerrar() {
		this.estado = EspacioFisicoEstado.CERRADO_TEMPORALMENTE;
	}

	public String getNombrePuntosInteresByDistancia() {
		LinkedList<PuntoInteres> puntosInteresAux = new LinkedList<PuntoInteres>(puntosInteres);
		puntosInteresAux.sort((p1, p2) -> Double.compare(p1.getDistancia(), p2.getDistancia()));
		return puntosInteresAux.stream().map(p -> p.toString()).collect(Collectors.joining(""));
	}

	@Override
	public String toString() {
		return "EspacioFisico [nombre=" + nombre + ", direccionPostal=" + direccion + "]\n"
				+ this.getNombrePuntosInteresByDistancia();
	}

}
