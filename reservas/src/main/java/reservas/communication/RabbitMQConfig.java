package reservas.communication;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class RabbitMQConfig {
	public static final String EXCHANGE_NAME = "bus";
	public static final String EVENTOS_QUEUE_NAME = "eventos";
	public static final String EVENTOS_BINDING_KEY = "bus.eventos.#";
	public static final String RESERVAS_QUEUE_NAME = "reservas";
	public static final String RESERVAS_BINDING_KEY = "bus.reservas.#";

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue queueEventos() {
		boolean durable = true;
		boolean exclusive = false;
		boolean autodelete = false;
		return new Queue(EVENTOS_QUEUE_NAME, durable, exclusive, autodelete);
	}

	@Bean
	public Binding bindingEventos() {
		return BindingBuilder.bind(queueEventos()).to(exchange()).with(EVENTOS_BINDING_KEY);
	}

	@Bean
	public Queue queueReservas() {
		boolean durable = true;
		boolean exclusive = false;
		boolean autodelete = false;
		return new Queue(RESERVAS_QUEUE_NAME, durable, exclusive, autodelete);
	}

	@Bean
	public Binding bindingReservas() {
		return BindingBuilder.bind(queueReservas()).to(exchange()).with(RESERVAS_BINDING_KEY);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return new Jackson2JsonMessageConverter(objectMapper);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter converter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter);
		return rabbitTemplate;
	}

	public static String generarRoutingKey(String tipoEvento) {
		return EXCHANGE_NAME + "." + EVENTOS_QUEUE_NAME + "." + tipoEvento;
	}
}
