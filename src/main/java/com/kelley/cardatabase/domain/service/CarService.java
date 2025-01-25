package com.kelley.cardatabase.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kelley.cardatabase.domain.model.Car;
import com.kelley.cardatabase.domain.repository.CarRepository;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColor(color);
    }
}