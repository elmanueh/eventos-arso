package eventos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EspacioFisico")
public class EspacioFisico {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	private String nombre;
	private String propietario;
	private String direccion;
	private boolean activo;
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

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
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
