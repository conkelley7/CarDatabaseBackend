package com.kelley.cardatabase.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kelley.cardatabase.domain.model.Car;

/**
 * Repository for 'Car' Entity class.
 */
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
	
	/**
	 *  Fetch cars by brand
	 * @param brand
	 * @return List of Cars matching brand
	 */
	List<Car> findByBrand(String brand);
	
	/**
	 * 
	 * @param color
	 * @return List of Cars matching color
	 */
	List<Car> findByColor(String color);
}
