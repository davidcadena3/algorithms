package co.david.cadena.algorithms.dto;

import java.util.Objects;

import co.david.cadena.algorithms.exception.AlgorithmsException;
import co.david.cadena.algorithms.exception.EalgorithmsExceptions;

public class SearchResponseDTO extends ResponseDTO {

	private int[] numbers;
	private int item;
	private int matchPosition;
	private int iterations;

	public SearchResponseDTO(String tId) {
		super(tId);
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getMatchPosition() {
		return matchPosition;
	}

	public void setMatchPosition(int matchPosition) {
		this.matchPosition = matchPosition;
	}
	
	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public static SearchResponseDTO fromRequest(String tId, SearchRequestDTO dto)
			throws AlgorithmsException {

		if (Objects.isNull(dto)) {
			throw new AlgorithmsException(tId, EalgorithmsExceptions.BAD_REQUEST);
		}

		SearchResponseDTO response = new SearchResponseDTO(tId);
		response.numbers = dto.getNumbers();
		response.item = dto.getItem();
		return response;
	}

}
