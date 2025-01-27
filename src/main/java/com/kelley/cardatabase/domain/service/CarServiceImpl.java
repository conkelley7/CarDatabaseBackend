package com.kelley.cardatabase.domain.service;

import org.springframework.stereotype.Service;

import com.kelley.cardatabase.domain.model.Car;
import com.kelley.cardatabase.domain.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    
    @Override
    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }
    
    @Override
    public Iterable<Car> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    @Override
    public Iterable<Car> getCarsByColor(String color) {
        return carRepository.findByColor(color);
    }
}