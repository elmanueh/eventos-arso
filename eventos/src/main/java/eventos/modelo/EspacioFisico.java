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
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String nombre;
	private String propietario;
	private String direccion;

	public EspacioFisico() {

	}

	public EspacioFisico(String nombre, String propietario, int capacidad, String direccion, double latitud,
			double longitud, String descripcion) {
		this.nombre = nombre;
		this.propietario = propietario;
		this.direccion = direccion;
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

	@Override
	public String toString() {
		return "EspacioFisico [nombre=" + nombre + ", direccionPostal=" + direccion + "]";
	}

}
