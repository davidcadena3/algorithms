package co.david.cadena.algorithms.dto;

import co.david.cadena.algorithms.exception.AlgorithmsException;

public class ErrorResponseDTO extends ResponseDTO {

	String message;

	public ErrorResponseDTO(AlgorithmsException ex) {
		super(ex.gettId());
		this.message = ex.getMessage();
	}

	public String getMessage() {
		return message;
	}

}
