package co.david.cadena.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.david.cadena.algorithms.dto.SearchRequestDTO;
import co.david.cadena.algorithms.dto.SearchResponseDTO;
//github.com/davidcadena3/algorithms.git
import co.david.cadena.algorithms.exception.AlgorithmsException;
import co.david.cadena.algorithms.service.BinarySearchService;
import co.david.cadena.algorithms.service.SimpleSearchService;

@SpringBootTest
class AlgorithmsApplicationTests {

	@Autowired
	private SimpleSearchService simpleSearchService;

	@Autowired
	private BinarySearchService binarySearchService;

	private final String tId = UUID.randomUUID().toString();

	@Test
	void simpleSearchOk() throws AlgorithmsException {
		SearchResponseDTO response = simpleSearchService.search(tId, new SearchRequestDTO(new int[] { 1, 2, 3, 4 }, 3));
		assertNotNull(response);
		assertEquals(2, response.getMatchPosition());
	}

	@Test
	void simpleSearchNonOk() throws AlgorithmsException {
		assertThrows(AlgorithmsException.class, () -> {
			simpleSearchService.search(tId, new SearchRequestDTO(new int[] { 1, 2, 3, 4 }, 5));
		});
	}

	@Test
	void simpleSearchBadRequest() throws AlgorithmsException {
		assertThrows(AlgorithmsException.class, () -> {
			simpleSearchService.search(tId, new SearchRequestDTO());
		});
	}

	@Test
	void binarySearchOk() throws AlgorithmsException {
		SearchResponseDTO response = binarySearchService.search(tId, new SearchRequestDTO(new int[] { 1, 2, 3, 4 }, 3));
		assertNotNull(response);
		assertEquals(2, response.getMatchPosition());
	}

	@Test
	void binarySearchNonOk() throws AlgorithmsException {
		assertThrows(AlgorithmsException.class, () -> {
			binarySearchService.search(tId, new SearchRequestDTO(new int[] { 1, 2, 3, 4 }, 5));
		});
	}

	@Test
	void binarySearchBadRequest() throws AlgorithmsException {
		assertThrows(AlgorithmsException.class, () -> {
			binarySearchService.search(tId, new SearchRequestDTO());
		});
	}

}
