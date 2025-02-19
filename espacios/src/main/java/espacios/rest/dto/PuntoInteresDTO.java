package espacios.rest.dto;

public class PuntoInteresDTO {
	private String nombre;
	private String descripcion;
	private float distancia;
	private String url;

	public PuntoInteresDTO() {
	}

	// Getters
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

}
