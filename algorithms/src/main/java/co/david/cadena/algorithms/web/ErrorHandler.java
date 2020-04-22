package co.david.cadena.algorithms.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.david.cadena.algorithms.dto.ErrorResponseDTO;
import co.david.cadena.algorithms.exception.AlgorithmsException;
import co.david.cadena.algorithms.exception.EalgorithmsExceptions;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponseDTO> handleAllExceptions(Exception ex, WebRequest request) {
		log.warn("Exception: " + ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		return new ResponseEntity(new ErrorResponseDTO(new AlgorithmsException(null, EalgorithmsExceptions.UNKNOWN)),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AlgorithmsException.class)
	public final ResponseEntity<ErrorResponseDTO> handleAllAlgorithmsException(AlgorithmsException ex,
			WebRequest request) {
		log.warn(ex.gettId() + " -> AlgorithmsException: " + ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		return new ResponseEntity(new ErrorResponseDTO(ex), ex.getStatus());
	}

}
