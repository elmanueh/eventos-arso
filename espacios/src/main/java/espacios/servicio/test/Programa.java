package espacios.servicio.test;

import java.util.LinkedList;

import espacios.modelo.PuntoInteres;
import espacios.servicio.IPuntosDeInteres;
import espacios.servicio.IServicioEspacios;
import espacios.servicio.PuntosDeInteres;
import espacios.servicio.ServicioEspacios;

public class Programa {

	public static void main(String[] args) {

		IServicioEspacios servicioEspacios = new ServicioEspacios();
		IPuntosDeInteres servicioPuntosDeInteres = new PuntosDeInteres();

		// PRUEBA GENERAL

		try {
			// Creación de Espacios Físicos
			String idEspacio1 = servicioEspacios.altaEspacioFisico("Plaza de Toros de la Condomina",
					"Plaza de Toros de Murcia, S.A.", 15000,
					"Ronda de Garay, Murcia, España", 37.984123153048316, -1.1291804565199284,
					"Plaza de toros de Murcia, ianugurado en 1886");
			System.out.println("Espacio fisico 1 creado con id: " + idEspacio1);

			String idEspacio2 = servicioEspacios.altaEspacioFisico("Estadio Riyadh Air Metropolitano", "ATM", 70460,
					"Avenida de Luis Aragonés, Nº 4, Madrid, España", 40.436111, -3.599444,
					"Estadio del Atletico de Madrid, inaugurado en 2016");
			System.out.println("Espacio fisico 2 creado con id: " + idEspacio2);

			String idEspacio3 = servicioEspacios.altaEspacioFisico("Palacio Euskalduna", "Público", 10000,
					"Avenida Abandoibarra, 4, Bilbao, España",
					43.266944, -2.944722, "Centro de convenciones y de espectáculos situado en la villa de Bilbao");
			System.out.println("Espacio fisico 3 creado con id: " + idEspacio3);

			String idEspacio4 = servicioEspacios.altaEspacioFisico("Cine Velasco", "Público", 750,
					"Av. Santa Eulalia, 24, Totana, Murcia, España",
					37.772256690148545, -1.5020068809646678,
					"Cuenta con unas 750 butacas, siendo el aforo de salas de cine más grande de la Región de Murcia.");
			System.out.println("Espacio fisico 4 creado con id: " + idEspacio4);
			System.out.println();

			// Fallo al crear espacios físico
			try {
				servicioEspacios.altaEspacioFisico(null, "Plaza de Toros de Murcia, S.A.", 15000,
						"Ronda de Garay, Murcia, España", 37.984123153048316, -1.1291804565199284,
						"Plaza de toros de Murcia, ianugurado en 1886");
			} catch (IllegalArgumentException e) {
				System.out.println("Espacio físico 5 no ha podido ser creado debido a: " + e);
			}
			System.out.println();

			// Asignar Puntos de Interes a los Espacios Físicos
			LinkedList<PuntoInteres> puntosInteres1 = new LinkedList<PuntoInteres>(
					servicioPuntosDeInteres.obtenerPuntosInteres(37.984123153048316, -1.1291804565199284));
			servicioEspacios.asignarPuntosDeInteres(idEspacio1, puntosInteres1);

			LinkedList<PuntoInteres> puntosInteres2 = new LinkedList<PuntoInteres>(
					servicioPuntosDeInteres.obtenerPuntosInteres(40.436111, -3.599444));
			servicioEspacios.asignarPuntosDeInteres(idEspacio2, puntosInteres2);

			LinkedList<PuntoInteres> puntosInteres3 = new LinkedList<PuntoInteres>(
					servicioPuntosDeInteres.obtenerPuntosInteres(43.266944, -2.944722));
			servicioEspacios.asignarPuntosDeInteres(idEspacio3, puntosInteres3);

			// Fallo al asignar puntos de interes
			try {
				servicioEspacios.asignarPuntosDeInteres(null, puntosInteres3);
			} catch (IllegalArgumentException e) {
				System.out.println("No se han podido asignar los puntos de interes al espacio físico: " + e);
			}
			System.out.println();

			// Modificar espacios fisicos
			servicioEspacios.modificarEspacioFisico(idEspacio1, null, -1, null);
			servicioEspacios.modificarEspacioFisico(idEspacio3,
					"Palacio de Congresos y de la Música Euskalduna Jauregia", 8000, null);

			// Fallo al modificar un espacio físico
			try {
				servicioEspacios.modificarEspacioFisico(null, "Palacio de congresos Murcia", 8000, null);
			} catch (IllegalArgumentException e) {
				System.out.println("No se ha podido modificar el espacio físico: " + e);
			}
			System.out.println();

			/*
			 * 
			 * // Creación de Eventos en los Espacios Físicos
			 * 
			 * // Eventos en Espacio Fisico 1 -> Plaza de Toros de la Condomina
			 * String idEvento1 = servicioEventos.altaEvento("Concierto Taylor Siwft",
			 * "Concierto número 27 de su gira por Europa", "Taylor Siwft",
			 * EventoCategoria.CULTURALES, LocalDateTime.of(2025, 1, 1, 0, 0),
			 * LocalDateTime.of(2025, 1, 3, 0, 0), 15000, idEspacio1);
			 * System.out.println("Evento 1 creado con id: " + idEvento1 +
			 * ", en el espacio físico " + idEspacio1);
			 * 
			 * String idEvento2 =
			 * servicioEventos.altaEvento("Corrida de Toros - Feria de Murcia",
			 * "Corrida de toros con los mejores toreros de España",
			 * "Federación Española de Toros", EventoCategoria.CULTURALES,
			 * LocalDateTime.of(2025, 9, 15, 18, 0),
			 * LocalDateTime.of(2025, 9, 15, 21, 0), 12000, idEspacio1);
			 * System.out.println("Evento 2 creado con id: " + idEvento2 +
			 * ", en el espacio físico " + idEspacio1);
			 * 
			 * String idEvento3 =
			 * servicioEventos.altaEvento("Festival de Flamenco - Feria de Murcia",
			 * "Festival de flamenco con grandes artistas como José Mercé y Niña Pastori",
			 * "Asociación Flamenca de Murcia",
			 * EventoCategoria.CULTURALES, LocalDateTime.of(2025, 9, 20, 21, 0),
			 * LocalDateTime.of(2025, 9, 20, 23, 0), 14000, idEspacio1);
			 * System.out.println("Evento 3 creado con id: " + idEvento3 +
			 * ", en el espacio físico " + idEspacio1);
			 * 
			 * String idEvento4 =
			 * servicioEventos.altaEvento("Concierto de Rock - Fito & Fitipaldis",
			 * "Concierto de la banda Fito & Fitipaldis como parte de su gira nacional",
			 * "Fito & Fitipaldis", EventoCategoria.CULTURALES,
			 * LocalDateTime.of(2025, 1, 10, 20, 0), LocalDateTime.of(2025, 1, 10, 23, 0),
			 * 15000, idEspacio1);
			 * System.out.println("Evento 4 creado con id: " + idEvento4 +
			 * ", en el espacio físico " + idEspacio1);
			 * 
			 * 
			 * // Eventos en Espacio Fisico 2 -> Estadio Riyadh Air Metropolitano
			 * String idEvento5 =
			 * servicioEventos.altaEvento("Partido Atlético de Madrid vs FC Barcelona",
			 * "Partido de la Liga Española entre Atlético de Madrid y FC Barcelona",
			 * "La Liga", EventoCategoria.DEPORTES,
			 * LocalDateTime.of(2025, 2, 10, 20, 0), LocalDateTime.of(2025, 2, 10, 22, 0),
			 * 70460, idEspacio2);
			 * System.out.println("Evento 5 creado con id: " + idEvento5 +
			 * ", en el espacio físico " + idEspacio2);
			 * 
			 * String idEvento6 =
			 * servicioEventos.altaEvento("Concierto Coldplay - Music of the Spheres Tour",
			 * "Concierto de la banda Coldplay como parte de su gira mundial", "Coldplay",
			 * EventoCategoria.CULTURALES,
			 * LocalDateTime.of(2025, 1, 1, 0, 0), LocalDateTime.of(2025, 1, 4, 0, 0),
			 * 70000, idEspacio2);
			 * System.out.println("Evento 6 creado con id: " + idEvento6 +
			 * ", en el espacio físico " + idEspacio2);
			 * 
			 * 
			 * // Eventos en Espacio Fisico 2 -> Palacio de Congresos y de la Música
			 * Euskalduna Jauregia
			 * String idEvento7 =
			 * servicioEventos.altaEvento("Congreso Internacional de Innovación Tecnológica"
			 * ,
			 * "Congreso anual sobre avances en la innovación y tecnología", "Innovatech",
			 * EventoCategoria.ACADEMICOS,
			 * LocalDateTime.of(2025, 1, 13, 9, 0), LocalDateTime.of(2025, 1, 13, 18, 0),
			 * 3000, idEspacio3);
			 * System.out.println("Evento 7 creado con id: " + idEvento7 +
			 * ", en el espacio físico " + idEspacio3);
			 * 
			 * String idEvento8 = servicioEventos.altaEvento("Ópera - La Traviata",
			 * "Representación de la famosa ópera de Verdi, La Traviata",
			 * "Teatro de la Ópera de Bilbao", EventoCategoria.CULTURALES,
			 * LocalDateTime.of(2025, 2, 25, 19, 0),
			 * LocalDateTime.of(2025, 2, 25, 22, 0), 2000, idEspacio3);
			 * System.out.println("Evento 8 creado con id: " + idEvento8 +
			 * ", en el espacio físico " + idEspacio3);
			 * 
			 * System.out.println();
			 * 
			 * 
			 * // Fallo al crear evento, aforo no disponible
			 * try {
			 * servicioEventos.altaEvento("Feria de Empleo y Formación Profesional",
			 * "Evento dedicado a la orientación laboral y las oportunidades de formación",
			 * "Gobierno Vasco", EventoCategoria.OTROS,
			 * LocalDateTime.of(2024, 10, 15, 10, 0), LocalDateTime.of(2024, 10, 15, 18, 0),
			 * 50000, idEspacio3);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("Evento 9 no ha podido ser creado debido a: " + e);
			 * }
			 * System.out.println();
			 * 
			 * 
			 * // Fallo al crear evento, espacio físico cerrado temporalmente
			 * try {
			 * servicioEspacios.bajaEspacioFisico(idEspacio4);
			 * servicioEventos.altaEvento("Actuación del Mago Pop",
			 * "El magnífico mago pop realizará trucos espectaculares, que te dejarán con la boca abierta"
			 * , "Gobierno Vasco",
			 * EventoCategoria.ENTRETENIMIENTO, LocalDateTime.of(2025, 4, 12, 20, 0),
			 * LocalDateTime.of(2025, 4, 12, 22, 0), 700, idEspacio4);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("Evento 10 no ha podido ser creado debido a: " + e);
			 * } finally {
			 * //servicioEspacios.activarEspacioFisico(idEspacio4);
			 * }
			 * System.out.println();
			 * 
			 * 
			 * // Fallo al crear evento, crear 2 eventos en la misma fecha
			 * try {
			 * servicioEventos.altaEvento("Actuación del Mago Pop",
			 * "El magnífico mago pop realizará trucos espectaculares, que te dejarán con la boca abierta"
			 * , "Gobierno Vasco",
			 * EventoCategoria.ENTRETENIMIENTO, LocalDateTime.of(2025, 1, 1, 0, 0),
			 * LocalDateTime.of(2025, 1, 3, 0, 0), 15000, idEspacio1);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("Evento 11 no ha podido ser creado debido a: " + e);
			 * }
			 * System.out.println();
			 * 
			 * 
			 * // Fallo al crear evento
			 * try {
			 * servicioEventos.altaEvento(null,
			 * "Evento dedicado a la orientación laboral y las oportunidades de formación",
			 * "Gobierno Vasco", EventoCategoria.OTROS,
			 * LocalDateTime.of(2024, 10, 15, 10, 0), LocalDateTime.of(2024, 10, 15, 18, 0),
			 * 50000, idEspacio3);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("Evento 12 no ha podido ser creado debido a: " + e);
			 * }
			 * System.out.println();
			 * 
			 * 
			 * 
			 * // Modificar evento
			 * servicioEventos.modificarEvento(idEvento7, null, null, null, -1, null);
			 * System.out.println("Evento con id: " + idEvento7 +
			 * " ha sido modificado. (NO SE HA CAMBIADO NADA)");
			 * 
			 * servicioEventos.modificarEvento(idEvento8,
			 * "Representación de la famosa ópera de Verdi, La Traviata. Aumento de aforo debido al cambio de fecha"
			 * ,
			 * LocalDateTime.of(2025, 2, 26, 19, 0), LocalDateTime.of(2025, 2, 26, 22, 0),
			 * 5000, null);
			 * System.out.println("Evento con id: " + idEvento8 +
			 * " ha sido modificado. (SE HA CAMBIADO FECHA, AFORO y DESCRIPCIÓN)");
			 * System.out.println();
			 * 
			 * // Fallo al modificar evento
			 * try {
			 * servicioEventos.modificarEvento(null, null, null, null, -1, null);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("Evento no ha podido ser modificado: " + e);
			 * }
			 * System.out.println();
			 * 
			 * 
			 * 
			 * // Cancelar evento
			 * servicioEventos.cancelarEvento(idEvento7);
			 * System.out.println("Evento con id: " + idEvento7 +
			 * " ha sido cancelado y eliminado su respectiva ocupación.");
			 * System.out.println();
			 * 
			 * // Fallo al cancelar evento
			 * try {
			 * servicioEventos.cancelarEvento(null);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("Evento no ha podido ser cancelado: " + e);
			 * }
			 * System.out.println();
			 * 
			 * 
			 * 
			 * // Mostrar eventos de un mes
			 * System.out.println("Los eventos del mes de Enero de 2025 son los siguientes:"
			 * );
			 * String eventosEnero2025 = servicioEventos.eventosDelMes(2, 2025);
			 * System.out.println(eventosEnero2025.isEmpty() ?
			 * "NO HAY EVENTOS PARA LA FECHA INDICADA (1-2025)" : eventosEnero2025);
			 * 
			 * System.out.println("Los eventos del mes de Marzo de 2025 son los siguientes:"
			 * );
			 * String eventosMarzo2025 = servicioEventos.eventosDelMes(3, 2025);
			 * System.out.println(eventosMarzo2025.isEmpty() ?
			 * "NO HAY EVENTOS PARA LA FECHA INDICADA (3-2025)" : eventosMarzo2025);
			 * System.out.println();
			 * 
			 * // Fallo al obtener eventos del mes
			 * try {
			 * servicioEventos.eventosDelMes(13, 2025);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("No se han podido obtener eventos en el mes y años: " +
			 * e);
			 * }
			 * System.out.println();
			 * 
			 * 
			 * 
			 * // Buscar espacios fisicos disponibles
			 * System.out.
			 * println("Los espacios físicos disponibles para el 24 de Feberero de 2025 de 9-21 son:"
			 * );
			 * List<EspacioFisico> espacios24Febrero2025 =
			 * servicioEspacios.buscarEspaciosFisicosLibres(LocalDateTime.of(2025, 2, 24, 9,
			 * 0),
			 * LocalDateTime.of(2024, 2, 24, 21, 0), 100);
			 * if (espacios24Febrero2025.isEmpty())
			 * System.out.
			 * println("NO HAY ESPACIOS FISICOS PARA LA FECHA INDICADA (24-2-2025)");
			 * else {
			 * for (EspacioFisico e : espacios24Febrero2025) {
			 * System.out.println(e);
			 * }
			 * }
			 * System.out.println();
			 * 
			 * System.out.
			 * println("Los espacios físicos disponibles para el 2 de Enero de 2025 son:");
			 * List<EspacioFisico> espacios2Enero2025 =
			 * servicioEspacios.buscarEspaciosFisicosLibres(LocalDateTime.of(2025, 1, 2, 9,
			 * 0),
			 * LocalDateTime.of(2025, 1, 2, 23, 0), 1000);
			 * if (espacios2Enero2025.isEmpty())
			 * System.out.
			 * println("NO HAY ESPACIOS FISICOS PARA LA FECHA INDICADA (2-1-2025)");
			 * else {
			 * for (EspacioFisico e : espacios2Enero2025) {
			 * System.out.println(e);
			 * }
			 * }
			 * System.out.println();
			 * 
			 * 
			 * // Descativo espacio físico (El que está disponible el 2 de Enero de 2025)
			 * servicioEspacios.bajaEspacioFisico(idEspacio3);
			 * System.out.println("El espacio físico con id: " + idEspacio3 +
			 * " ha sido puesto de baja.");
			 * System.out.println();
			 * 
			 * 
			 * // Volver a comprobar eventos para 2 de Enero
			 * System.out.
			 * println("Los espacios físicos disponibles para el 2 de Enero de 2025 son:");
			 * espacios2Enero2025 =
			 * servicioEspacios.buscarEspaciosFisicosLibres(LocalDateTime.of(2025, 1, 2, 9,
			 * 0), LocalDateTime.of(2025, 1, 2, 23, 0),
			 * 1000);
			 * if (espacios2Enero2025.isEmpty())
			 * System.out.
			 * println("NO HAY ESPACIOS FISICOS PARA LA FECHA INDICADA (2-1-2025)");
			 * else {
			 * for (EspacioFisico e : espacios2Enero2025) {
			 * System.out.println(e);
			 * }
			 * }
			 * System.out.println();
			 * 
			 * 
			 * 
			 * // Activar espacio físico (El que acabamos de desactivar)
			 * servicioEspacios.activarEspacioFisico(idEspacio3);
			 * System.out.println("El espacio físico con id: " + idEspacio3 +
			 * " ha sido activado de nuevo.");
			 * System.out.println();
			 * 
			 * 
			 * 
			 * // Volver a comprobar eventos para 2 de Enero (Mostrará igual que antes, solo
			 * 1 espacio)
			 * System.out.
			 * println("Los espacios físicos disponibles para el 2 de Enero de 2025 son:");
			 * espacios2Enero2025 =
			 * servicioEspacios.buscarEspaciosFisicosLibres(LocalDateTime.of(2025, 1, 2, 9,
			 * 0), LocalDateTime.of(2025, 1, 2, 23, 0),
			 * 1000);
			 * if (espacios2Enero2025.isEmpty())
			 * System.out.
			 * println("NO HAY ESPACIOS FISICOS PARA LA FECHA INDICADA (2-1-2025)");
			 * else {
			 * for (EspacioFisico e : espacios2Enero2025) {
			 * System.out.println(e);
			 * }
			 * }
			 * System.out.println();
			 * 
			 * 
			 * 
			 * // Fallo al dar de baja un espacio físico
			 * try {
			 * servicioEspacios.bajaEspacioFisico(null);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("No se ha podido dar de baja el espacio físico: " + e);
			 * }
			 * System.out.println();
			 * 
			 * // Fallo al activar un espacio físico
			 * try {
			 * servicioEspacios.activarEspacioFisico(null);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("No se ha podido activar el espacio físico: " + e);
			 * }
			 * System.out.println();
			 * 
			 * // Fallo al buscar espacios físicos libres
			 * try {
			 * servicioEspacios.buscarEspaciosFisicosLibres(null, LocalDateTime.of(2025, 1,
			 * 2, 23, 0), 1000);
			 * } catch (IllegalArgumentException e) {
			 * System.out.println("No se han podido buscar espacios físico libres: " + e);
			 * }
			 * System.out.println();
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Fin del programa de pruebas.");
	}
}
