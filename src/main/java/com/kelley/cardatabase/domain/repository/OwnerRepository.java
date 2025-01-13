package com.kelley.cardatabase.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.kelley.cardatabase.domain.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
