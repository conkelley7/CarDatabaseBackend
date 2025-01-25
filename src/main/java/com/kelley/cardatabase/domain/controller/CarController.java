package com.kelley.cardatabase.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kelley.cardatabase.domain.model.Car;
import com.kelley.cardatabase.domain.service.CarService;

@RestController
public class CarController {
	
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Fetch and return all cars
     */
    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        return carService.getAllCars();
    }

    /**
     * Get cars by brand
     */
    @GetMapping("/cars/brand/{brand}")
    public Iterable<Car> getCarByBrand(@PathVariable("brand") String brand) {
        return carService.getCarsByBrand(brand);
    }

    /**
     * Get cars by color
     */
    @GetMapping("/cars/color/{color}")
    public Iterable<Car> getCarByColor(@PathVariable("color") String color) {
        return carService.getCarsByColor(color);
    }
}
