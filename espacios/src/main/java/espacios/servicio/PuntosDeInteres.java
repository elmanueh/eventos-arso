package espacios.servicio;

import java.util.LinkedList;
import java.util.List;

import espacios.modelo.PuntoInteres;

public class PuntosDeInteres implements IPuntosDeInteres {

	@Override
	public List<PuntoInteres> obtenerPuntosInteres(double latitud, double longitud) {
		String xmlResponse = GeoNamesAPI.getPuntosInteresCercanos(latitud, longitud);
		LinkedList<PuntoInteres> puntosInteres = XMLProcessor.procesarXML(xmlResponse);
		return puntosInteres;
	}
}
