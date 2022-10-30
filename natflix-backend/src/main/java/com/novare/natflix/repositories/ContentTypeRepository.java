package com.novare.natflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novare.natflix.models.ContentType;

public interface ContentTypeRepository extends JpaRepository<ContentType, Integer> {

}
