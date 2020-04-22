package co.david.cadena.algorithms.exception;

import org.springframework.http.HttpStatus;

public enum EalgorithmsExceptions {

	UNKNOWN("unknown exception", HttpStatus.INTERNAL_SERVER_ERROR),
	BAD_REQUEST("bad request", HttpStatus.BAD_REQUEST), 
	NOT_FOUND("not found", HttpStatus.NOT_FOUND);

	private String message;
	private HttpStatus status;

	private EalgorithmsExceptions(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	String getMessage() {
		return message;
	}

	HttpStatus getStatus() {
		return status;
	}

}
