package eventos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "espacioFisico")
public class EspacioFisico {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getPropietario() {
		return propietario;
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

	@Override
	public String toString() {
		return "EspacioFisico [nombre=" + nombre + ", direccionPostal=" + direccion + "]";
	}

}
