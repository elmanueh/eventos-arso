package espacios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PuntoInteres")
public class PuntoInteres {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String nombre;

	@Lob
	private String descripcion;
	private float distancia;

	@Lob
	private String url;

	public PuntoInteres() {

	}

	public PuntoInteres(String nombre, String descripcion, float distancia, String url) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distancia = distancia;
		this.url = url;
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

	@Override
	public String toString() {
		return "PuntoInteres [nombre=" + nombre + ", distancia = " + distancia + "]\n";
	}

}
