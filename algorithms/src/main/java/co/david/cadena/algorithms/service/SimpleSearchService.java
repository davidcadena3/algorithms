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
public class SimpleSearchService {

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

		int it = 0;

		for (int guess : numbers) {
			log.info(tId + " -> iteration: " + it + " guessItem: " + guess);
			if (guess == item) {
				log.info(tId + " -> item found at " + it + " position");
				response.setMatchPosition(it);
				response.setIterations(it + 1);
				return;
			}
			it++;
		}

		throw new AlgorithmsException(tId, "item: " + item + " not found", EalgorithmsExceptions.NOT_FOUND);
	}

}
