package eventos.rest;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.web.PagedResourcesAssembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

import eventos.modelo.Evento;
import eventos.modelo.EventoCategoria;
import eventos.repositorio.exception.EntidadNoEncontrada;
import eventos.rest.dto.CreateEventoDTO;
import eventos.rest.dto.EventoResponseDTO;
import eventos.rest.dto.EventoResumen;
import eventos.rest.dto.UpdateEventoDTO;
import eventos.rest.hateoas.EventoResumenAssembler;
import eventos.rest.mapper.EventoMapper;
import eventos.servicio.IServicioEventos;
import eventos.servicio.reservas.exception.RetrofitException;

@RestController
@RequestMapping("/eventos")
public class ControladorEventos {
	private final IServicioEventos servicio;

	@Autowired
	public ControladorEventos(IServicioEventos servicio) {
		this.servicio = servicio;
	}

	@Autowired
	private PagedResourcesAssembler<EventoResumen> pagedResourcesAssembler;

	@Autowired
	private EventoResumenAssembler eventoResumenAssembler;

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('GESTOR_EVENTOS', 'USUARIO')")
	public EventoResponseDTO getEvento(@PathVariable String id) throws EntidadNoEncontrada {
		Evento evento = servicio.recuperarEvento(id);
		return EventoMapper.toDTO(evento);
	}

	@PostMapping()
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public ResponseEntity<Void> createEvento(@Valid @RequestBody CreateEventoDTO eventoDTO)
			throws EntidadNoEncontrada {
		String id = servicio.altaEvento(eventoDTO.getNombre(), eventoDTO.getDescripcion(),
				eventoDTO.getOrganizador(), EventoCategoria.valueOf(eventoDTO.getCategoria()),
				LocalDateTime.parse(eventoDTO.getFechaInicio()), LocalDateTime.parse(eventoDTO.getFechaFin()),
				eventoDTO.getNumPlazas(), eventoDTO.getEspacioFisico());

		URI nuevaURL = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(nuevaURL).build();
	}

	@PatchMapping("/{id}")
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public ResponseEntity<Void> updateEvento(@PathVariable String id, @Valid @RequestBody UpdateEventoDTO eventoDTO)
			throws EntidadNoEncontrada, RetrofitException {

		LocalDateTime fechaInicio = eventoDTO.getFechaInicio() != null
				? LocalDateTime.parse(eventoDTO.getFechaInicio())
				: null;

		LocalDateTime fechaFin = eventoDTO.getFechaFin() != null
				? LocalDateTime.parse(eventoDTO.getFechaInicio())
				: null;

		servicio.modificarEvento(id, eventoDTO.getDescripcion(),
				fechaInicio, fechaFin, eventoDTO.getNumPlazas(),
				eventoDTO.getEspacioFisico());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}/ocupacion")
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public ResponseEntity<Void> cancelEvento(@PathVariable String id) throws EntidadNoEncontrada {
		servicio.cancelarEvento(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping()
	@PreAuthorize("hasAnyAuthority('GESTOR_EVENTOS', 'USUARIO')")
	public PagedModel<EntityModel<EventoResumen>> getlistadoPaginado(@RequestParam int mes, @RequestParam int año,
			Pageable pageable) throws EntidadNoEncontrada {

		Page<EventoResumen> resultado = servicio.eventosDelMesPaginados(mes, año, pageable);
		return pagedResourcesAssembler.toModel(resultado, eventoResumenAssembler);
	}

	@GetMapping("/ocupacion/{id}")
	public ResponseEntity<Boolean> isAlgunaOcupacion(@PathVariable String id) {
		return ResponseEntity.ok(servicio.isAlgunaOcupacion(id));
	}

	@GetMapping("/espacioslibres")
	public List<String> buscarEspaciosFisicosLibres(
			@RequestParam String fechaInicio,
			@RequestParam String fechaFin,
			@RequestParam int capacidad) {

		return servicio.buscarEspaciosFisicosLibres(
				LocalDateTime.parse(fechaInicio), LocalDateTime.parse(fechaFin), capacidad);
	}
}