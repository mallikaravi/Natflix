package com.novare.natflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novare.natflix.exceptions.NatflixException;
import com.novare.natflix.models.Content;
import com.novare.natflix.models.Documentaries;
import com.novare.natflix.models.EType;
import com.novare.natflix.models.Movies;
import com.novare.natflix.models.Series;
import com.novare.natflix.payload.ContentDTO;
import com.novare.natflix.repositories.ContentRepository;
import com.novare.natflix.repositories.DocumentariesRepository;
import com.novare.natflix.repositories.MoviesRepository;
import com.novare.natflix.repositories.SeriesRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Validated
public class CustomerContentController {
	@Autowired
	private ContentRepository contentRepository;
	@Autowired
	private DocumentariesRepository documentariesRepository;
	@Autowired
	private SeriesRepository seriesRepository;
	@Autowired
	private MoviesRepository moviesRepository;

	@GetMapping("/content")
//    @PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<List<ContentDTO>> findAll() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.CONTENT);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping("/content/movies")
//    @PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<List<ContentDTO>> findMovies() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.MOVIES);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping("/content/series")
//    @PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<List<ContentDTO>> findSeries() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.SERIES);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping("/content/documentaries")
//    @PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<List<ContentDTO>> findDocumentries() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.DOCUMENTARIES);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping({"/content/details-series/{id}", "/details-series/{id}"})
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<List<ContentDTO>> getBySeriesId(@PathVariable(value = "id") Integer seriesId)
			throws NatflixException {
		Series series = seriesRepository.findById(seriesId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Series not found on :: " + seriesId));
		List<ContentDTO> response = ContentDTO.buildSeriesDTO(series);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping({"/content/details-movies/{id}", "/details-movies/{id}"})
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<ContentDTO> getByMoviesId(@PathVariable(value = "id") Integer movieId)
			throws NatflixException {
		Movies movies = moviesRepository.findById(movieId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Movie not found on :: " + movieId));
		ContentDTO response = ContentDTO.createResponse(movies.getAdditional(), movies.getId(),
				movies.getCategory().getId(), 1);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping({"/content/details-documentaries/{id}","/details-documentaries/{id}"})
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<ContentDTO> getByDocId(@PathVariable(value = "id") Integer documentId)
			throws NatflixException {
		Documentaries documentaries = documentariesRepository.findById(documentId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Series not found on :: " + documentId));
		ContentDTO response = ContentDTO.createResponse(documentaries.getAdditionalDetails(), documentaries.getId(),
				documentaries.getCategory().getId(), 1);
		return ResponseEntity.ok().body(response);
	}

}