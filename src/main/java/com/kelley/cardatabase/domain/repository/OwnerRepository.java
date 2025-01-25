package com.kelley.cardatabase.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kelley.cardatabase.domain.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	/**
	 * Find an owner by their first name.
	 * @param firstName
	 * @return Owner (Optional) matching First Name
	 */
	Optional<Owner> findByFirstName(String firstName);
}
