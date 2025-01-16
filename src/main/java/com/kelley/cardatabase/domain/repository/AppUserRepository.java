package com.kelley.cardatabase.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kelley.cardatabase.domain.model.AppUser;

// Hides Repository, so that User information is not exposed through a REST endpoint automatically by Spring Data REST.
@RepositoryRestResource(exported=false)
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	Optional<AppUser> findByUsername(String username);
}
