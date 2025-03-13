package reservas.modelo;

import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "eventos")
public class Evento {

    @Id
    private String id;

    @Field("plazasDisponibles")
    private int plazasDisponibles;

    @Field("cancelado")
    private boolean cancelado;

    @DBRef
    @Field("reservas")
    private LinkedList<Reserva> reservas;

    public Evento() {
        this.reservas = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public LinkedList<Reserva> getReservas() {
        return new LinkedList<>(reservas);
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void reservarPlazas(int numPlazas) {
        this.plazasDisponibles -= numPlazas;
    }
}
