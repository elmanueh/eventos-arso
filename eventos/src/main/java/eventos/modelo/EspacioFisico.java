package eventos.modelo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "espacioFisico")
public class EspacioFisico {

	@SuppressWarnings("deprecation")
	@Id
	@Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "VARCHAR(36)")
	private UUID id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "propietario")
	private String propietario;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "cancelado")
	private boolean cancelado;

	@Column(name = "capacidad")
	private int capacidad;

	public EspacioFisico() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getPropietario() {
		return propietario;
	}

	@Override
	public String toString() {
		return "EspacioFisico [nombre=" + nombre + ", direccionPostal=" + direccion + "]";
	}

}
