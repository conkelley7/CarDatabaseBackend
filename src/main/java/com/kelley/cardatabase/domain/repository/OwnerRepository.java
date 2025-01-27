package com.kelley.cardatabase.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kelley.cardatabase.domain.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	
	
	/**
	 * Find an owner by their first name.
	 * @param firstName
	 * @return List of owners matching the last name.
	 */
	List<Owner> findByFirstName(String firstName);
	
	/**
	 * 
	 * @param lastName
	 * @return List of owners matching the last name.
	 */
	List<Owner> findByLastName(String lastName);
}
