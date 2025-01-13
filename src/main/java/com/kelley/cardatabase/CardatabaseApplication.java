package com.kelley.cardatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kelley.cardatabase.domain.model.Car;
import com.kelley.cardatabase.domain.model.Owner;
import com.kelley.cardatabase.domain.repository.CarRepository;
import com.kelley.cardatabase.domain.repository.OwnerRepository;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementing CommandLineRunner to add demo data to MariaDB database upon application startup.
 */
@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
	
	public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started successfully.");
	}
	
	/*
	 * Overriding run method and adding demonstration data to MariaDB database.
	 */
	@Override
	public void run(String... args) throws Exception{
		// Add owners to database
		Owner owner1 = new Owner("John", "Doe");
		Owner owner2 = new Owner("Jane", "Doe");
		
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		
		// Add car objects and assign to owners in database
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
		carRepository.save(new Car("Jeep", "Patriot", "Navy", "CPK-5561", 2016, 4200, owner2));
		
		// Fetching all cars just added and logging them in console
		for (Car car : carRepository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
		
	}

}
