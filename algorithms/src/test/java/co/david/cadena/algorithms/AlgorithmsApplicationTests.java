package co.david.cadena.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.david.cadena.algorithms.dto.BinarySearchRequestDTO;
import co.david.cadena.algorithms.dto.BinarySearchResponseDTO;
import co.david.cadena.algorithms.exception.AlgorithmsException;
import co.david.cadena.algorithms.service.BinarySearchService;

@SpringBootTest
class AlgorithmsApplicationTests {

	@Autowired
	private BinarySearchService binaryService;

	private final String tId = UUID.randomUUID().toString();

	@Test
	void binarySearchOk() throws AlgorithmsException {
		BinarySearchResponseDTO response = binaryService.search(tId,
				new BinarySearchRequestDTO(new int[] { 1, 2, 3, 4 }, 3));
		assertNotNull(response);
		assertEquals(2, response.getMatchPosition());
	}

	@Test
	void binarySearchNonOk() throws AlgorithmsException {
		assertThrows(AlgorithmsException.class, () -> {
			binaryService.search(tId, new BinarySearchRequestDTO(new int[] { 1, 2, 3, 4 }, 5));
		});
	}

	@Test
	void binarySearchBadRequest() throws AlgorithmsException {
		assertThrows(AlgorithmsException.class, () -> {
			binaryService.search(tId, new BinarySearchRequestDTO());
		});
	}

}
