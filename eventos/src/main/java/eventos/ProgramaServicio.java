package eventos;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import eventos.modelo.EventoCategoria;
import eventos.servicio.IServicioEventos;

public class ProgramaServicio {

        public static void main(String[] args) throws Exception {
                ConfigurableApplicationContext contexto = SpringApplication.run(EventosApplication.class, args);

                IServicioEventos servicio = contexto.getBean(IServicioEventos.class);

                String idEspacio = "1";

                // Crear eventos
                String idEvento1 = servicio.altaEvento("Tech Conference", "Evento de tecnología", "John Doe",
                                EventoCategoria.ACADEMICOS, LocalDateTime.of(2025, 3, 10, 10, 0),
                                LocalDateTime.of(2025, 3, 10, 18, 0), 100, idEspacio);

                String idEvento2 = servicio.altaEvento("Concierto Rock", "Concierto en vivo", "Alice Smith",
                                EventoCategoria.OTROS, LocalDateTime.of(2025, 4, 15, 20, 0),
                                LocalDateTime.of(2025, 4, 15, 23, 0), 500, idEspacio);

                System.out.println("Evento con id 1: " + servicio.recuperarEvento(idEvento1));
                System.out.println("Evento con id 2: " + servicio.recuperarEvento(idEvento2));

                // Este recuperarEspacioFisico falla
                try {
                        System.out.println("Evento con id 3: " + servicio.recuperarEvento("3"));
                } catch (Exception e) {
                        System.out.println(e);
                }

                // Modificar evento1 aforo a 120
                servicio.modificarEvento(idEvento1, null, null, null, 120, null);
                System.out.println("Evento con id 1 modificado: " + servicio.recuperarEvento(idEvento1));

                // Cancelar evento2
                servicio.cancelarEvento(idEvento2);
                System.out.println("Evento con id 2 cancelado: " + servicio.recuperarEvento(idEvento2));

                // Consultar eventos del mes de Marzo
                System.out.println("Eventos del mes de Marzo: " + servicio.eventosDelMes(3, 2025));

                contexto.close();
        }

}
