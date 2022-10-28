package com.novare.natflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novare.natflix.models.Content;

public interface ContentRepository extends JpaRepository<Content, Integer> {

}
