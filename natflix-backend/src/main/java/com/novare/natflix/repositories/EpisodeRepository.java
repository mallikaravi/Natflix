package com.novare.natflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novare.natflix.models.Episodes;

public interface EpisodeRepository extends JpaRepository<Episodes, Integer>{

}
