package reservas.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import reservas.servicio.ReservaResumen;

@Component
public class ReservaResumenAssembler
		implements RepresentationModelAssembler<ReservaResumen, EntityModel<ReservaResumen>> {

	@Override
	public EntityModel<ReservaResumen> toModel(ReservaResumen reserva) {
		try {
			EntityModel<ReservaResumen> resultado = EntityModel.of(reserva,
					linkTo(methodOn(ControladorReservas.class).getReserva(reserva.getId())).withSelfRel());
			return resultado;
		} catch (Exception e) {
			return EntityModel.of(reserva);
		}
	}
}
