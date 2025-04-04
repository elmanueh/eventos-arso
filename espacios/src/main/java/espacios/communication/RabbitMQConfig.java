package espacios.communication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import io.github.cdimascio.dotenv.Dotenv;

public class RabbitMQConfig {
	private static RabbitMQConfig instance;

	private static final String QUEUE_NAME = "espacios";
	private static final String EXCHANGE_NAME = "bus";
	// private static final String ESPACIOS_BINDING_KEY = "bus.espacios.#";
	private static final Dotenv dotenv = Dotenv.load();
	private static final String RABBITMQ_URL = dotenv.get("RABBITMQ_URL");

	private Connection connection;
	private Channel channel;

	private RabbitMQConfig() {
	}

	public static RabbitMQConfig getInstance() {
		if (instance == null) {
			instance = new RabbitMQConfig();
		}
		return instance;
	}

	public void startRabbitMQ() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setUri(RABBITMQ_URL);

			connection = factory.newConnection();
			channel = connection.createChannel();
		} catch (Exception e) {
			throw new RuntimeException("Error al conectar con RabbitMQ", e);
		}
	}

	public void stopRabbitMQ() {
		try {
			if (channel != null)
				channel.close();
			if (connection != null)
				connection.close();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}

	public void publishEvent(RabbitEvent event) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		try {
			String mensaje = objectMapper.writeValueAsString(event);
			channel.basicPublish(EXCHANGE_NAME, generarRoutingKey(event.getTipoEvento()),
					new AMQP.BasicProperties.Builder().build(), mensaje.getBytes());
		} catch (Exception e) {
			throw new RuntimeException("Error al publicar el evento", e);
		}
	}

	private String generarRoutingKey(String tipoEvento) {
		return EXCHANGE_NAME + "." + QUEUE_NAME + "." + tipoEvento;
	}

}
