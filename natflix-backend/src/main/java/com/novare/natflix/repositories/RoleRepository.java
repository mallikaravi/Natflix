package com.novare.natflix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novare.natflix.models.ERole;
import com.novare.natflix.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	  Optional<Role> findByName(ERole name);

}