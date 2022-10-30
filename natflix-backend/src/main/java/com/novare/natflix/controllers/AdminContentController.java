package com.novare.natflix.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novare.natflix.exceptions.NatflixException;
import com.novare.natflix.models.Content;
import com.novare.natflix.models.ContentCategory;
import com.novare.natflix.models.Documentaries;
import com.novare.natflix.models.EType;
import com.novare.natflix.models.Episodes;
import com.novare.natflix.models.Movies;
import com.novare.natflix.models.Series;
import com.novare.natflix.payload.ContentDTO;
import com.novare.natflix.repositories.CategoryRepository;
import com.novare.natflix.repositories.ContentRepository;
import com.novare.natflix.repositories.DocumentariesRepository;
import com.novare.natflix.repositories.EpisodeRepository;
import com.novare.natflix.repositories.MoviesRepository;
import com.novare.natflix.repositories.SeriesRepository;
import com.novare.natflix.services.IContentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Validated
public class AdminContentController {
	@Autowired
	private ContentRepository contentRepository;
	@Autowired
	private DocumentariesRepository documentariesRepository;
	@Autowired
	private SeriesRepository seriesRepository;
	@Autowired
	private MoviesRepository moviesRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private EpisodeRepository episodeRepository;
	@Autowired
	private IContentService contentService;

	@GetMapping("/admin-content")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<List<ContentDTO>> findAll() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.CONTENT);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping("/admin-content/movies")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<List<ContentDTO>> findMovies() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.MOVIES);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping("/admin-content/series")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<List<ContentDTO>> findSeries() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.SERIES);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping("/admin-content/documentaries")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<List<ContentDTO>> findDocumentries() throws NatflixException {
		List<Content> contents = contentRepository.findAll();
		List<ContentDTO> responses = ContentDTO.get(contents, EType.DOCUMENTARIES);
		return ResponseEntity.ok().body(responses);
	}

	@GetMapping("/admin-details-series/{id}")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<List<ContentDTO>> getBySeriesId(@PathVariable(value = "id") Integer seriesId)
			throws NatflixException {
		Series series = seriesRepository.findById(seriesId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Series not found on :: " + seriesId));
		List<ContentDTO> response = ContentDTO.buildSeriesDTO(series);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/admin-details-movies/{id}")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<ContentDTO> getByMoviesId(@PathVariable(value = "id") Integer movieId)
			throws NatflixException {
		Movies movies = moviesRepository.findById(movieId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Movie not found on :: " + movieId));
		ContentDTO response = ContentDTO.createResponse(movies.getAdditional(), movies.getId(),
				movies.getCategory().getId(), 1);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/admin-details-documentaries/{id}")
//	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	public ResponseEntity<ContentDTO> getByDocId(@PathVariable(value = "id") Integer documentId)
			throws NatflixException {
		Documentaries documentaries = documentariesRepository.findById(documentId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Series not found on :: " + documentId));
		ContentDTO response = ContentDTO.createResponse(documentaries.getAdditionalDetails(), documentaries.getId(),
				documentaries.getCategory().getId(), 1);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/admin-content/create")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ContentDTO> create(@RequestBody ContentDTO contentRequest) throws NatflixException {

		saveOrUpdate(contentRequest);

		return ResponseEntity.ok(contentRequest);
	}

	@PutMapping("/admin-content/update")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ContentDTO> update(@RequestBody ContentDTO contentRequest) throws NatflixException {
		saveOrUpdate(contentRequest);
		return ResponseEntity.ok(contentRequest);
	}

	@DeleteMapping("/admin-content/delete-series/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteSeries(@PathVariable(value = "id") Integer seriesId) throws NatflixException {

		Series series = seriesRepository.findById(seriesId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Series not found on :: " + seriesId));
		seriesRepository.delete(series);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/admin-content/delete-episode/{id}")
//  @PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteEpisode(@PathVariable(value = "id") Integer episodeId) throws NatflixException {

		Episodes episode = episodeRepository.findById(episodeId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Episode not found on :: " + episodeId));
		episodeRepository.delete(episode);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/admin-content/delete-movies/{id}")
//  @PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") Integer movieId) throws NatflixException {

		Movies movies = moviesRepository.findById(movieId)
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND, "Movie not found on :: " + movieId));
		moviesRepository.delete(movies);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/admin-content/delete-documentaries/{id}")
//  @PreAuthorize("hasRole('ADMIN')")
	public Map<String, Boolean> deleteDocumentaries(@PathVariable(value = "id") Integer documentId)
			throws NatflixException {

		Documentaries documentaries = documentariesRepository.findById(documentId).orElseThrow(
				() -> new NatflixException(HttpStatus.NOT_FOUND, "Documentaries not found on :: " + documentId));
		documentariesRepository.delete(documentaries);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	private void saveOrUpdate(ContentDTO contentRequest) {
		ContentCategory category = categoryRepository.findById(contentRequest.getCatId())
				.orElseThrow(() -> new NatflixException(HttpStatus.NOT_FOUND,
						"Category not found on :: " + contentRequest.getCatId()));
		switch (contentRequest.getTypeId()) {
			case 1 -> {
				Series series = ContentDTO.createSeriesModel(contentRequest);
				series.setCategory(category);
				Content findByContentType = contentService.findByContentType(EType.SERIES.name());
				series.setContent(findByContentType);
				seriesRepository.save(series);
			}
			case 2 -> {
				Movies movies = ContentDTO.createMoviesModel(contentRequest);
				movies.setCategory(category);
				Content findByContentType = contentService.findByContentType(EType.SERIES.name());
				movies.setContent(findByContentType);
				moviesRepository.save(movies);
			}
			case 3 -> {
				Documentaries documentaries = ContentDTO.createDocumentModel(contentRequest);
				documentaries.setCategory(category);
				Content findByContentType = contentService.findByContentType(EType.SERIES.name());
				documentaries.setContent(findByContentType);
				documentariesRepository.save(documentaries);
			}

			default -> throw new IllegalArgumentException("Unexpected value: " + contentRequest.getTypeId());
		}
	}
}