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

import co.david.cadena.algorithms.dto.ResponseDTO;
import co.david.cadena.algorithms.dto.SearchRequestDTO;
import co.david.cadena.algorithms.service.BinarySearchService;
import co.david.cadena.algorithms.service.SimpleSearchService;

@RestController
@RequestMapping(value = "algorithms/v1.0/")
public class Controller {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SimpleSearchService simpleSearch;

	@Autowired
	private BinarySearchService binarySearch;

	@CrossOrigin
	@PostMapping(value = "simple-search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO simpleSearch(@RequestBody SearchRequestDTO request) throws Exception {
		String tId = UUID.randomUUID().toString();
		log.info(tId + " -> request: " + request);
		return simpleSearch.search(tId, request);
	}

	@CrossOrigin
	@PostMapping(value = "binary-search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseDTO binarySearch(@RequestBody SearchRequestDTO request) throws Exception {
		String tId = UUID.randomUUID().toString();
		log.info(tId + " -> request: " + request);
		return binarySearch.search(tId, request);
	}

}
