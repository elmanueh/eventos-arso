package reservas.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
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
public class ControladorReservas {
	private final IServicioReservas servicio;

	@Autowired
	public ControladorReservas(IServicioReservas servicio) {
		this.servicio = servicio;
	}

	@Autowired
	private PagedResourcesAssembler<ReservaResumen> pagedResourcesAssembler;

	@Autowired
	private ReservaResumenAssembler reservaAssembler;

	// reservar
	@PostMapping()
	public ResponseEntity<Void> createReserva(@Valid @RequestBody CreateReservaDTO reservaDTO)
			throws EntidadNoEncontrada {

		String id = servicio.reservar(reservaDTO.getIdEvento(), reservaDTO.getIdUsuario(), reservaDTO.getNumPlazas());

		URI nuevaURL = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(nuevaURL).build();
	}

	// recuperarReserva
	@GetMapping("/{id}")
	public ReservaResponseDTO getReserva(@PathVariable String id) throws EntidadNoEncontrada {
		Reserva reserva = servicio.recuperarReserva(id);
		return ReservaMapper.toDTO(reserva);
	}

	// recuperarTodasReservas
	@GetMapping("/evento/{id}")
	public PagedModel<EntityModel<ReservaResumen>> getlistadoPaginado(@PathVariable String id,
			Pageable pageable) throws EntidadNoEncontrada {

		Page<ReservaResumen> resultado = servicio.recuperarTodasReservas(id, pageable);
		return pagedResourcesAssembler.toModel(resultado, reservaAssembler);
	}

}