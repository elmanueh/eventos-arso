package reservas.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reservas")
public class Reserva {
	
    @Id
    private String id;
    
    @Field("idUsuario")
    private String idUsuario;
    
    @Field("plazasReservadas")
    private int plazasReservadas;
    
    @Field("cancelada")
    private boolean cancelada;

    @DBRef
    @Field("evento")
    private Evento evento;

    public Reserva() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPlazasReservadas() {
        return plazasReservadas;
    }

    public void setPlazasReservadas(int plazasReservadas) {
        this.plazasReservadas = plazasReservadas;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
