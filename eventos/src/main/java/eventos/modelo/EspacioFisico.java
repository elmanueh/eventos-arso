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

}
