package reservas.communication;

public interface IEventProducer {

	void publicarReservaCreado(String idEntidad, Object entidad);

}
