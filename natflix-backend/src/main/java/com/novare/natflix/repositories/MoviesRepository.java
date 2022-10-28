package com.novare.natflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novare.natflix.models.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {

}
