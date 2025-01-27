package com.kelley.cardatabase.domain.service;

import org.springframework.stereotype.Service;

import com.kelley.cardatabase.domain.model.Owner;
import com.kelley.cardatabase.domain.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	
	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}
	
	@Override
	public Iterable<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}

	@Override
	public Iterable<Owner> getOwnersByFirstName(String firstName) {
		return ownerRepository.findByFirstName(firstName);
	}

	@Override
	public Iterable<Owner> getOwnersByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}
	
}
