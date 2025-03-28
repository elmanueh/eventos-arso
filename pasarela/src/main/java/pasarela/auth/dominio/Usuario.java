package pasarela.auth.dominio;

import java.util.UUID;

public class Usuario {
	private UUID id;
	private String usuario;
	private String contraseña;
	private String roles;

	public Usuario() {
	}

	public Usuario(UUID id, String usuario, String contraseña, String roles) {
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.roles = roles;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
