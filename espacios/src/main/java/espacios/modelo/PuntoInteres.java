package espacios.modelo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "puntoInteres")
public class PuntoInteres {

	@Id
	@Column(name = "id", columnDefinition = "VARCHAR(36)")
	private UUID id;

	@Column(name = "nombre")
	private String nombre;

	@Lob
	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "distancia")
	private float distancia;

	@Lob
	@Column(name = "url")
	private String url;

	public PuntoInteres() {

	}

	public PuntoInteres(String nombre, String descripcion, float distancia, String url) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distancia = distancia;
		this.url = url;
	}

	@PrePersist
	public void generateUUID() {
		if (id == null) {
			id = UUID.randomUUID();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getDistancia() {
		return distancia;
	}

	public String getUrl() {
		return url;
	}

	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PuntoInteres [nombre=" + nombre + ", distancia = " + distancia + "]\n";
	}

}
