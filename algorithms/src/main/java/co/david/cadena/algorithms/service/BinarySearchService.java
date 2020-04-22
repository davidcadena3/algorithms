package co.david.cadena.algorithms.service;

import java.util.Arrays;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.david.cadena.algorithms.dto.SearchRequestDTO;
import co.david.cadena.algorithms.dto.SearchResponseDTO;
import co.david.cadena.algorithms.exception.AlgorithmsException;
import co.david.cadena.algorithms.exception.EalgorithmsExceptions;

@Service
public class BinarySearchService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	public SearchResponseDTO search(String tId, SearchRequestDTO dto) throws AlgorithmsException {
		log.info(tId + " -> dto: " + dto);
		SearchResponseDTO response = SearchResponseDTO.fromRequest(tId, dto);
		searchElementPosition(tId, dto.getNumbers(), dto.getItem(), response);
		return response;
	}

	private void searchElementPosition(String tId, int[] numbers, int item, SearchResponseDTO response)
			throws AlgorithmsException {

		log.info(tId + " -> numbers: " + numbers + ", item: " + item);

		// invalid numbers
		if (Objects.isNull(numbers) || numbers.length < 1) {
			throw new AlgorithmsException(tId, EalgorithmsExceptions.BAD_REQUEST);
		}

		Arrays.sort(numbers);
		log.info(tId + " -> ordered numbers: " + numbers);

		// lower position
		int low = 0;
		// higher position
		int high = numbers.length - 1;

		int it = 0;

		while (low <= high) {
			it++;
			int middle = (low + high) / 2;
			int guess = numbers[middle];

			log.info(tId + " -> iteration: " + it + " low: " + low + " middle: " + middle + " high: " + high
					+ " guessItem: " + guess);

			if (guess == item) {
				log.info(tId + " -> item found at " + middle + " position");
				response.setMatchPosition(middle);
				response.setIterations(it + 1);
				return;
			} else if (guess > item) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		throw new AlgorithmsException(tId, "item: " + item + " not found", EalgorithmsExceptions.NOT_FOUND);
	}

}
