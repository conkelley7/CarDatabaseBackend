package com.kelley.cardatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kelley.cardatabase.domain.model.Car;
import com.kelley.cardatabase.domain.repository.CarRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementing CommandLineRunner to add demo data to H2 database upon application startup.
 */
@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	private final CarRepository carRepository;
	
	public CardatabaseApplication(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started successfully.");
	}
	
	/*
	 * Overriding run method and adding demonstration data to H2 database.
	 */
	@Override
	public void run(String... args) throws Exception{
		// Saving two sample cars to H2 database.
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000));
		
		// Fetching all cars just added and logging them in console
		for (Car car : carRepository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
		
	}

}
