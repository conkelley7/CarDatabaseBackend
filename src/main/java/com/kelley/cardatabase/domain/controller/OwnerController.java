package com.kelley.cardatabase.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kelley.cardatabase.domain.model.Owner;
import com.kelley.cardatabase.domain.service.OwnerService;

@RestController
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@GetMapping("/owners")
	public Iterable<Owner> getAllOwners() {
		return ownerService.getAllOwners();
	}
	
	@GetMapping("/owners/firstName/{firstName}")
	public Iterable<Owner> getOwnerByFirstName(@PathVariable("firstName") String firstName) {
		return ownerService.getOwnersByFirstName(firstName);
	}
	
	@GetMapping("/owners/lastName/{lastName}")
	public Iterable<Owner> getOwnerByLastName(@PathVariable("lastName") String lastName) {
		return ownerService.getOwnersByLastName(lastName);
	}
}
