package espacios.servicio.puntosInteres;

import java.util.List;

import espacios.modelo.PuntoInteres;

public interface IPuntosDeInteres {

	List<PuntoInteres> obtenerPuntosInteres(double latitud, double longitud);
}
