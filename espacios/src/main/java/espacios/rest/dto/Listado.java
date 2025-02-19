package espacios.rest.dto;

import java.util.List;

public class Listado {
    public static class ResumenExtendido {
        private String url;
        private ResumenEspacioFisicoResponseDTO espacioDTO;

        // Métodos get y set
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ResumenEspacioFisicoResponseDTO getEspacioDTO() {
            return espacioDTO;
        }

        public void setEspacioDTO(ResumenEspacioFisicoResponseDTO espacioDTO) {
            this.espacioDTO = espacioDTO;
        }

    }

    private List<ResumenExtendido> espacio;
    // Métodos get y set

    public List<ResumenExtendido> getEspacio() {
        return espacio;
    }

    public void setEspacio(List<ResumenExtendido> espacio) {
        this.espacio = espacio;
    }

}