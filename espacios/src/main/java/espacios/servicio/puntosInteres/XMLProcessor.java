package espacios.servicio.puntosInteres;

import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import espacios.modelo.PuntoInteres;

import java.io.StringReader;

public class XMLProcessor {

	// Método para procesar el XML y extraer los puntos de interés
	public static LinkedList<PuntoInteres> procesarXML(String xml) {
		LinkedList<PuntoInteres> listaPuntos = new LinkedList<>();

		try {
			// Procesar la respuesta XML usando DOM
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder analizador = factoria.newDocumentBuilder();
			InputSource enlace = new InputSource(new StringReader(xml));
			Document documento = analizador.parse(enlace);

			// Obtener todos los elementos 'entry' del XMLs
			NodeList entries = documento.getElementsByTagName("entry");

			// Iterar sobre los resultados y agregar a la lista
			for (int i = 0; i < entries.getLength(); i++) {
				Element entry = (Element) entries.item(i);

				// Extraer la información que desees (title, summary, lat, lng)
				String title = entry.getElementsByTagName("title").item(0).getTextContent();
				String summary = entry.getElementsByTagName("summary").item(0).getTextContent();
				String distance = entry.getElementsByTagName("distance").item(0).getTextContent();
				String wikipediaUrl = entry.getElementsByTagName("wikipediaUrl").item(0).getTextContent();

				// Crear un objeto PuntoInteres y añadirlo a la lista
				PuntoInteres punto = new PuntoInteres(title, summary, Float.parseFloat(distance), wikipediaUrl);
				listaPuntos.add(punto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Devolver la lista de puntos de interés
		return listaPuntos;
	}
}
