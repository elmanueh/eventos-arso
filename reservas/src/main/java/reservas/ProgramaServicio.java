package reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import reservas.servicio.IServicioReservas;

public class ProgramaServicio {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext contexto = SpringApplication.run(ReservasApplication.class, args);

        IServicioReservas servicio = contexto.getBean(IServicioReservas.class);
        
        // ANTES DE HACER LA PRUEBA EN ATLAS ACTUALIZAR A 100 LAS PLAZAS DEL EVENTO 1
        
        String idEvento1 = "67c1aca232ed8bfcf566c422";
        String idEvento2 = "67c1acb632ed8bfcf566c423";
        
        String idUsuario1 = "1";
        
        // HACER RESERVA
        String idReserva1 = servicio.reservar(idEvento1, idUsuario1, 50); 
        String idReserva2 = servicio.reservar(idEvento1, idUsuario1, 25);
        
        // RECUPERAR RESERVA
        System.out.println("Reserva con id: " + idReserva1);
        System.out.println("Reserva con id: " + idReserva2);
        
        // Esta reserva falla porque no hay suficientes plazas
        try {
        servicio.reservar(idEvento2, idUsuario1, 100);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        // RECUPERAR RESERVAS DE UN EVENTO
        System.out.println("Todas las reservas de evento id: " + idEvento1 + " son: " + servicio.recuperarTodasReservas(idEvento1));
        
        //Este es vacio
        System.out.println("Todas las reservas de evento id: " + idEvento2 + " son: " + servicio.recuperarTodasReservas(idEvento2));

	}

}
