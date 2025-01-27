package com.kelley.cardatabase.domain.service;

import com.kelley.cardatabase.domain.model.Car;

public interface CarService {
	
	Iterable<Car> getAllCars();
	
	Iterable<Car> getCarsByBrand(String brand);
	
	Iterable<Car> getCarsByColor(String color);
	
}
