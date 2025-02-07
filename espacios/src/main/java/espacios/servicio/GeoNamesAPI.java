package espacios.servicio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeoNamesAPI {

    // Método para hacer la solicitud a la API de GeoNames
    public static String getPuntosInteresCercanos(double lat, double longi) {
        String urlString = "http://api.geonames.org/findNearbyWikipedia?username=elmanueh&lang=ES&lat=" + lat + "&lng="
                + longi;

        try {
            // Crear el cliente HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Crear la solicitud HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Retornar el cuerpo de la respuesta
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
