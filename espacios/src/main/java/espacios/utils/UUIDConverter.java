package espacios.utils;

import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String> {

	@Override
	public String convertToDatabaseColumn(UUID uuid) {
		return uuid != null ? uuid.toString() : null;
	}

	@Override
	public UUID convertToEntityAttribute(String dbData) {
		return dbData != null ? UUID.fromString(dbData) : null;
	}
}