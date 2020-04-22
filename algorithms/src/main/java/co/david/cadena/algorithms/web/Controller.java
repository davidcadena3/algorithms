package co.david.cadena.algorithms.web;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.david.cadena.algorithms.dto.BinarySearchRequestDTO;
import co.david.cadena.algorithms.dto.ResponseDTO;
import co.david.cadena.algorithms.service.BinarySearchService;

@RestController
@RequestMapping(value = "algorithms/v1.0/")
public class Controller {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BinarySearchService binarySearch;

	@CrossOrigin
	@PostMapping(value = "binary-search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO binarySearch(@RequestBody BinarySearchRequestDTO request) throws Exception {
		String tId = UUID.randomUUID().toString();
		log.info(tId + " -> request: " + request);
		return binarySearch.search(tId, request);
	}

}
