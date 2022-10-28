package com.novare.natflix.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.novare.natflix.models.Movies;
import com.novare.natflix.models.Series;
import com.novare.natflix.payload.ContentDTO;
import com.novare.natflix.repositories.CategoryRepository;
import com.novare.natflix.repositories.ContentRepository;
import com.novare.natflix.repositories.DocumentariesRepository;
import com.novare.natflix.repositories.MoviesRepository;
import com.novare.natflix.repositories.SeriesRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/content")
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
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping()
//    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    public ResponseEntity<List<ContentDTO>> findAll() throws NatflixException {
        List<Content> contents = contentRepository.findAll();
        List<ContentDTO> responses = ContentDTO.get(contents, EType.CONTENT);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/movies")
//    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    public ResponseEntity<List<ContentDTO>> findMovies() throws NatflixException {
        List<Content> contents = contentRepository.findAll();
        List<ContentDTO> responses = ContentDTO.get(contents, EType.MOVIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/series")
//    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    public ResponseEntity<List<ContentDTO>> findSeries() throws NatflixException {
        List<Content> contents = contentRepository.findAll();
        List<ContentDTO> responses = ContentDTO.get(contents, EType.SERIES);
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping("/documentaries")
//    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    public ResponseEntity<List<ContentDTO>> findDocumentries() throws NatflixException {
        List<Content> contents = contentRepository.findAll();
        List<ContentDTO> responses = ContentDTO.get(contents, EType.DOCUMENTARIES);
        return ResponseEntity.ok().body(responses);
    }

    
    @PostMapping("/create")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ContentDTO> create(@Valid @RequestBody ContentDTO contentRequest)
            throws NatflixException {

        saveOrUpdate(contentRequest);

        return ResponseEntity.ok(contentRequest);
    }

    @PutMapping("/update")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ContentDTO> update(@Valid @RequestBody ContentDTO contentRequest)
            throws NatflixException {
        saveOrUpdate(contentRequest);
        return ResponseEntity.ok(contentRequest);
    }

    @DeleteMapping("/delete")
//    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteUser(@Valid @RequestBody ContentDTO contentRequest) throws NatflixException {
        switch (contentRequest.getTypeId()) {
            case 1 -> {
                Series series = seriesRepository.findById(contentRequest.getId()).orElseThrow(
                        () -> new NatflixException(HttpStatus.NOT_FOUND,
                                "Series not found on :: " + contentRequest.getId()));
                seriesRepository.delete(series);
            }
            case 2 -> {
                Movies movies = moviesRepository.findById(contentRequest.getId()).orElseThrow(
                        () -> new NatflixException(HttpStatus.NOT_FOUND,
                                "Movie not found on :: " + contentRequest.getId()));
                moviesRepository.save(movies);
            }
            case 3 -> {
                Documentaries documentaries = documentariesRepository.findById(contentRequest.getId()).orElseThrow(
                        () -> new NatflixException(HttpStatus.NOT_FOUND,
                                "Documentaries not found on :: " + contentRequest.getId()));
                documentariesRepository.save(documentaries);
            }

            default ->
                throw new IllegalArgumentException("Unexpected value: " + contentRequest.getTypeId());
        }
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private void saveOrUpdate(ContentDTO contentRequest) {
        ContentCategory category = categoryRepository.findById(contentRequest.getCatId()).orElseThrow(
                () -> new NatflixException(HttpStatus.NOT_FOUND,
                        "Category not found on :: " + contentRequest.getCatId()));
        switch (contentRequest.getTypeId()) {
            case 1 -> {
                Series series = ContentDTO.createSeriesModel(contentRequest);
                series.setCategory(category);
                seriesRepository.save(series);
            }
            case 2 -> {
                Movies movies = ContentDTO.createMoviesModel(contentRequest);
                movies.setCategory(category);
                moviesRepository.save(movies);
            }
            case 3 -> {
                Documentaries documentaries = ContentDTO.createDocumentModel(contentRequest);
                documentaries.setCategory(category);
                documentariesRepository.save(documentaries);
            }

            default ->
                throw new IllegalArgumentException("Unexpected value: " + contentRequest.getTypeId());
        }
    }

}