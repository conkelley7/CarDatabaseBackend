package com.kelley.cardatabase.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.kelley.cardatabase.domain.model.Car;

/**
 * Repository for 'Car' Entity class.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
