package eventos.rest.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import eventos.rest.ControladorEventos;
import eventos.rest.dto.EventoResumen;

@Component
public class EventoResumenAssembler implements RepresentationModelAssembler<EventoResumen, EntityModel<EventoResumen>> {

	@SuppressWarnings("null")
	@Override
	public EntityModel<EventoResumen> toModel(EventoResumen evento) {
		try {
			EntityModel<EventoResumen> resultado = EntityModel.of(evento,
					linkTo(methodOn(ControladorEventos.class).getEvento(evento.getId())).withSelfRel());
			return resultado;
		} catch (Exception e) {
			return EntityModel.of(evento);
		}
	}
}
