package eventos.rest.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class MessageError {

	private String status;
	private String error;
	private String message;
	private Map<String, String> validationErrors;

	public MessageError(HttpStatus httpStatus, String message) {
		this.status = String.valueOf(httpStatus.value());
		this.error = httpStatus.getReasonPhrase();
		this.message = message;
	}

	public MessageError(HttpStatus httpStatus, String message, Map<String, String> validationErrors) {
		this(httpStatus, message);
		this.validationErrors = validationErrors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}

}
