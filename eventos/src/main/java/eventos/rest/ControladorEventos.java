package eventos.rest;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

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
import eventos.servicio.reservas.IServicioReservasAPI;
import eventos.servicio.reservas.exception.RetrofitException;

@RestController
@RequestMapping("/eventos")
public class ControladorEventos {
	private final IServicioEventos servicio;
	private final IServicioReservasAPI servicioReservasAPI;

	@Autowired
	public ControladorEventos(IServicioEventos servicio, IServicioReservasAPI servicioReservasAPI) {
		this.servicio = servicio;
		this.servicioReservasAPI = servicioReservasAPI;
	}

	@Autowired
	private PagedResourcesAssembler<EventoResumen> pagedResourcesAssembler;

	@Autowired
	private EventoResumenAssembler eventoResumenAssembler;

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('GESTOR_EVENTOS', 'USUARIO')")
	public EntityModel<EventoResponseDTO> getEvento(@PathVariable UUID id)
			throws EntidadNoEncontrada, RetrofitException {
		Evento evento = servicio.recuperarEvento(id);
		EventoResponseDTO eventoDTO = EventoMapper.toDTO(evento);

		eventoDTO.setNumPlazasDisponibles(servicioReservasAPI.obtenerPlazasReservadas(id));

		EntityModel<EventoResponseDTO> model = EntityModel.of(eventoDTO);
		model.add(
				WebMvcLinkBuilder.linkTo(
						WebMvcLinkBuilder
								.methodOn(ControladorEventos.class)
								.getEvento(id))
						.withSelfRel());
		return model;
	}

	@PostMapping()
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public ResponseEntity<Void> createEvento(@Valid @RequestBody CreateEventoDTO eventoDTO)
			throws EntidadNoEncontrada {
		UUID id = servicio.altaEvento(eventoDTO.getNombre(), eventoDTO.getDescripcion(),
				eventoDTO.getOrganizador(), EventoCategoria.valueOf(eventoDTO.getCategoria()),
				LocalDateTime.parse(eventoDTO.getFechaInicio()), LocalDateTime.parse(eventoDTO.getFechaFin()),
				eventoDTO.getNumPlazas(), eventoDTO.getEspacioFisico());

		URI nuevaURL = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(nuevaURL).build();
	}

	@PatchMapping("/{id}")
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public ResponseEntity<Void> updateEvento(@PathVariable UUID id, @Valid @RequestBody UpdateEventoDTO eventoDTO)
			throws EntidadNoEncontrada, RetrofitException {

		LocalDateTime fechaInicio = eventoDTO.getFechaInicio() != null
				? LocalDateTime.parse(eventoDTO.getFechaInicio())
				: null;

		LocalDateTime fechaFin = eventoDTO.getFechaFin() != null
				? LocalDateTime.parse(eventoDTO.getFechaFin())
				: null;

		servicio.modificarEvento(id, eventoDTO.getDescripcion(),
				fechaInicio, fechaFin, eventoDTO.getNumPlazas(),
				eventoDTO.getEspacioFisico());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}/ocupacion")
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public ResponseEntity<Void> cancelEvento(@PathVariable UUID id) throws EntidadNoEncontrada {
		servicio.cancelarEvento(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping()
	@PreAuthorize("hasAnyAuthority('GESTOR_EVENTOS', 'USUARIO')")
	public PagedModel<EntityModel<EventoResumen>> getlistadoPaginado(@RequestParam(defaultValue = "0") int mes,
			@RequestParam(defaultValue = "0") int año,
			Pageable pageable) throws RetrofitException {

		Page<EventoResumen> resultado = servicio.eventosDelMesPaginados(mes, año, pageable);

		for (EventoResumen evento : resultado) {
			evento.setNumPlazasDisponibles(servicioReservasAPI.obtenerPlazasReservadas(evento.getId()));
		}

		return pagedResourcesAssembler.toModel(resultado, eventoResumenAssembler);
	}

	@GetMapping("/ocupacion/{id}")
	public ResponseEntity<Boolean> isAlgunaOcupacion(@PathVariable UUID id) {
		return ResponseEntity.ok(servicio.isAlgunaOcupacion(id));
	}

	@GetMapping("/espacioslibres")
	public List<UUID> buscarEspaciosFisicosLibres(
			@RequestParam String fechaInicio,
			@RequestParam String fechaFin,
			@RequestParam int capacidad) {

		return servicio.buscarEspaciosFisicosLibres(
				LocalDateTime.parse(fechaInicio), LocalDateTime.parse(fechaFin), capacidad);
	}

	@GetMapping("/espacio/{id}")
	public ResponseEntity<Integer> obtenerNumPlazasMayor(@PathVariable UUID id) {
		return ResponseEntity.ok(servicio.numPlazasMayor(id));
	}

	@GetMapping("/gestor/{gestor}")
	@PreAuthorize("hasAuthority('GESTOR_EVENTOS')")
	public PagedModel<EntityModel<EventoResumen>> getEventosPorGestor(@PathVariable String gestor, Pageable pageable)
			throws RetrofitException {
		Page<EventoResumen> resultado = servicio.recuperarEventosPorGestor(gestor, pageable);

		for (EventoResumen evento : resultado) {
			evento.setNumPlazasDisponibles(servicioReservasAPI.obtenerPlazasReservadas(evento.getId()));
		}

		return pagedResourcesAssembler.toModel(resultado, eventoResumenAssembler);
	}

}