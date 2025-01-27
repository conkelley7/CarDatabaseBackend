package com.kelley.cardatabase.domain.service;

import com.kelley.cardatabase.domain.model.Owner;

public interface OwnerService {
	
	Iterable<Owner> getAllOwners();
	
	Iterable<Owner> getOwnersByFirstName(String firstName);
	
	Iterable<Owner> getOwnersByLastName(String lastName);
}
