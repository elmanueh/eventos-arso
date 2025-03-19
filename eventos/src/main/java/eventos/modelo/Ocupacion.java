package eventos.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ocupacion")
public class Ocupacion {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;

	@Column(name = "fechaInicio")
	private LocalDateTime fechaInicio;

	@Column(name = "fechaFin")
	private LocalDateTime fechaFin;

	@ManyToOne
	@JoinColumn(name = "idEspacioFisico")
	private EspacioFisico espacioFisico;

	public Ocupacion() {

	}

	public Ocupacion(LocalDateTime fechaInicio, LocalDateTime fechaFin, EspacioFisico espacioFisico) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.espacioFisico = espacioFisico;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public EspacioFisico getEspacioFisico() {
		return espacioFisico;
	}

	public void setEspacioFisico(EspacioFisico espacioFisico) {
		this.espacioFisico = espacioFisico;
	}

	// Propieda Calculada
	public boolean isActiva() {
		LocalDateTime fechaActual = LocalDateTime.now();
		return fechaActual.isAfter(fechaInicio) && fechaActual.isBefore(fechaFin);
	}

	public boolean entreFechas(int mes, int año) {
		LocalDateTime fecha = LocalDateTime.of(año, mes, 1, 0, 0);
		return fechaInicio.isBefore(fecha) && fechaFin.isAfter(fecha);
	}

	@Override
	public String toString() {
		return "Ocupacion [fechaInicio=" + fechaInicio + "]\n" + espacioFisico.toString();
	}

}
