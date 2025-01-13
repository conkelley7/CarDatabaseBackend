package com.kelley.cardatabase.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kelley.cardatabase.domain.model.Car;
import com.kelley.cardatabase.domain.repository.CarRepository;

@RestController
public class CarController {
	
	private final CarRepository carRepository;
	
	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	/**
	 * Fetch and return all cars
	 */
	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return carRepository.findAll();
	}
}
