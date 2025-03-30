package reservas.rest;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import reservas.modelo.Reserva;
import reservas.repositorio.exception.EntidadNoEncontrada;
import reservas.rest.dto.ReservaResponseDTO;
import reservas.rest.dto.ReservaResumen;
import reservas.rest.hateoas.ReservaResumenAssembler;
import reservas.rest.dto.CreateReservaDTO;
import reservas.rest.mapper.ReservaMapper;
import reservas.servicio.IServicioReservas;

@RestController
@RequestMapping("/reservas")
public class ControladorReservas implements ReservasApi {
	private final IServicioReservas servicio;

	@Autowired
	public ControladorReservas(IServicioReservas servicio) {
		this.servicio = servicio;
	}

	@Autowired
	private PagedResourcesAssembler<ReservaResumen> pagedResourcesAssembler;

	@Autowired
	private ReservaResumenAssembler reservaAssembler;

	@PostMapping()
	@PreAuthorize("hasAuthority('USUARIO')")
	public ResponseEntity<Void> createReserva(@Valid @RequestBody CreateReservaDTO reservaDTO)
			throws EntidadNoEncontrada {

		UUID id = servicio.reservar(reservaDTO.getIdEvento(), reservaDTO.getIdUsuario(), reservaDTO.getNumPlazas());

		URI nuevaURL = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(nuevaURL).build();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('USUARIO')")
	public ReservaResponseDTO getReserva(@PathVariable UUID id) throws EntidadNoEncontrada {
		Reserva reserva = servicio.recuperarReserva(id);
		return ReservaMapper.toDTO(reserva);
	}

	@GetMapping("/evento/{id}")
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public PagedModel<EntityModel<ReservaResumen>> getListadoPaginado(@PathVariable UUID id, Pageable pageable)
			throws EntidadNoEncontrada {
		Page<ReservaResumen> resultado = servicio.recuperarTodasReservas(id, pageable);
		return pagedResourcesAssembler.toModel(resultado, reservaAssembler);
	}

	@GetMapping("/evento/{idEvento}/plazasReservadas")
	public ResponseEntity<Integer> obtenerPlazasReservadas(@PathVariable UUID idEvento) throws EntidadNoEncontrada {
		return ResponseEntity.ok(servicio.recuperarNumPlazasReservadas(idEvento));
	}

}