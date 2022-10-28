package com.novare.natflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novare.natflix.models.Series;

public interface SeriesRepository extends JpaRepository<Series, Integer> { 

}
