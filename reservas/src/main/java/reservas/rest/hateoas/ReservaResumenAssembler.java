package reservas.rest.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import reservas.repositorio.exception.EntidadNoEncontrada;
import reservas.rest.ControladorReservas;
import reservas.rest.dto.ReservaResumen;

@Component
public class ReservaResumenAssembler
		implements RepresentationModelAssembler<ReservaResumen, EntityModel<ReservaResumen>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<ReservaResumen> toModel(ReservaResumen reserva) {
		try {
			EntityModel<ReservaResumen> resultado = EntityModel.of(reserva,
					linkTo(methodOn(ControladorReservas.class).getReserva(reserva.getId())).withSelfRel());
			return resultado;
		} catch (EntidadNoEncontrada e) {
			return EntityModel.of(reserva);
		}
	}
}
