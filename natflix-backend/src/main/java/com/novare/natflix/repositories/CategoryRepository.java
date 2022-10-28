package com.novare.natflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novare.natflix.models.ContentCategory;

public interface CategoryRepository extends JpaRepository<ContentCategory, Integer> {

}
