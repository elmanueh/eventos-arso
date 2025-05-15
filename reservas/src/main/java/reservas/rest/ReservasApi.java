package reservas.rest;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import reservas.repositorio.exception.EntidadNoEncontrada;
import reservas.rest.dto.CreateReservaDTO;
import reservas.rest.dto.ReservaResponseDTO;
import reservas.rest.dto.ReservaResumen;
import reservas.rest.exception.MessageError;

public interface ReservasApi {

	@Operation(summary = "Crear una nueva reserva", description = "Crea una nueva reserva en el sistema. Se debe proporcionar un objeto válido con los datos de la reserva.", responses = {
			@ApiResponse(responseCode = "201", description = "Reserva creada exitosamente. No se devuelve contenido en el cuerpo de la respuesta."),
			@ApiResponse(responseCode = "404", description = "Entidad no encontrada. Esto ocurre si no se encuentra algún recurso relacionado necesario para crear la reserva.", content = @Content(schema = @Schema(implementation = MessageError.class)))
	})
	ResponseEntity<Void> createReserva(
			@Valid @RequestBody(description = "Datos necesarios para crear una nueva reserva", required = true) CreateReservaDTO reservaDTO)
			throws EntidadNoEncontrada;

	@Operation(summary = "Obtener una reserva", description = "Obtiene los detalles de una reserva específica a partir de su identificador único.", responses = {
			@ApiResponse(responseCode = "200", description = "Reserva encontrada exitosamente.", content = @Content(schema = @Schema(implementation = ReservaResponseDTO.class))),
			@ApiResponse(responseCode = "404", description = "Reserva no encontrada. Esto ocurre si no existe una reserva con el identificador proporcionado.", content = @Content(schema = @Schema(implementation = MessageError.class)))
	})
	EntityModel<ReservaResponseDTO> getReserva(
			@PathVariable(name = "Identificador único de la reserva", required = true) UUID id)
			throws EntidadNoEncontrada;

	@Operation(summary = "Listar reservas paginadas", description = "Obtiene un listado paginado de reservas asociadas a un recurso específico.", responses = {
			@ApiResponse(responseCode = "200", description = "Listado de reservas obtenido exitosamente.", content = @Content(schema = @Schema(implementation = PagedModel.class))),
			@ApiResponse(responseCode = "404", description = "Entidad no encontrada. Esto ocurre si no se encuentra el recurso relacionado para listar las reservas.", content = @Content(schema = @Schema(implementation = MessageError.class)))
	})
	PagedModel<EntityModel<ReservaResumen>> getListadoPaginado(
			@PathVariable(name = "Identificador único del recurso relacionado", required = true) UUID id,
			Pageable pageable) throws EntidadNoEncontrada;

	@Operation(summary = "Obtener plazas reservadas", description = "Obtiene el número de plazas reservadas para un evento específico.", responses = {
			@ApiResponse(responseCode = "200", description = "Número de plazas reservadas obtenido exitosamente.", content = @Content(schema = @Schema(implementation = Integer.class))),
			@ApiResponse(responseCode = "404", description = "Entidad no encontrada. Esto ocurre si no se encuentra el evento relacionado.", content = @Content(schema = @Schema(implementation = MessageError.class)))
	})
	ResponseEntity<Integer> obtenerPlazasReservadas(
			@PathVariable(name = "Identificador único del recurso relacionado", required = true) UUID idEvento)
			throws EntidadNoEncontrada;

	@Operation(summary = "Listar reservas por usuario", description = "Obtiene un listado paginado de reservas asociadas a un usuario específico.", responses = {
			@ApiResponse(responseCode = "200", description = "Listado de reservas obtenido exitosamente.", content = @Content(schema = @Schema(implementation = PagedModel.class))),
			@ApiResponse(responseCode = "404", description = "Entidad no encontrada. Esto ocurre si no se encuentra el usuario relacionado para listar las reservas.", content = @Content(schema = @Schema(implementation = MessageError.class)))
	})
	PagedModel<EntityModel<ReservaResumen>> getReservasPorUsuario(
			@PathVariable(name = "Identificador único del recurso relacionado", required = true) UUID idUsuario,
			Pageable pageable)
			throws EntidadNoEncontrada;
}
