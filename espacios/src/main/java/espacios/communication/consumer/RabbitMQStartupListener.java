package espacios.communication.consumer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import espacios.communication.RabbitMQConfig;

@WebListener
public class RabbitMQStartupListener implements ServletContextListener {
	private RabbitMQConfig rabbitMQ;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			rabbitMQ = RabbitMQConfig.getInstance();
			rabbitMQ.startRabbitMQ();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error al inicializar RabbitMQ: " + e.getMessage());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (rabbitMQ != null) {
			rabbitMQ.stopRabbitMQ();
		}
	}
}