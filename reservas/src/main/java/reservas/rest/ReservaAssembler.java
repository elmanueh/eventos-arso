package reservas.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import reservas.modelo.Reserva;

@Component
public class ReservaAssembler
		implements RepresentationModelAssembler<Reserva, EntityModel<Reserva>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<Reserva> toModel(Reserva reserva) {
		try {
			EntityModel<Reserva> resultado = EntityModel.of(reserva,
					linkTo(methodOn(ControladorReservas.class).getReserva(reserva.getId())).withSelfRel());
			return resultado;
		} catch (Exception e) {
			return EntityModel.of(reserva);
		}
	}
}
