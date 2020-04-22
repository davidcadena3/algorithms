package co.david.cadena.algorithms.exception;

import org.springframework.http.HttpStatus;

public class AlgorithmsException extends Exception {

	private static final long serialVersionUID = 1066049294280165747L;
	private String tId;
	private HttpStatus status;

	public AlgorithmsException(String tId, EalgorithmsExceptions exception) {
		super(exception.getMessage());
		this.tId = tId;
		this.status = exception.getStatus();
	}

	public AlgorithmsException(String tId, String message, EalgorithmsExceptions exception) {
		super(message);
		this.tId = tId;
		this.status = exception.getStatus();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String gettId() {
		return tId;
	}

}
