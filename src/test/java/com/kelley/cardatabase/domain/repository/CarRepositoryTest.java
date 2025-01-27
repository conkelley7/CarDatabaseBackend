package com.kelley.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kelley.cardatabase.domain.model.Car;
import com.kelley.cardatabase.domain.repository.CarRepository;

@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private CarRepository carRepository;
	
	@Test
	void findByBrandTest() {
		Car car = new Car("Ford", "F150", "White", "ABC-123", 2022, 50000, null);
		carRepository.save(car);
		
		List<Car> carList = carRepository.findByBrand("Ford");
		
		assertThat(carList.contains(car));
	}
	
	@Test
	void findByColorTest() {
		Car car = new Car("Ford", "F150", "White", "ABC-123", 2022, 50000, null);
		carRepository.save(car);
		
		List<Car> carList = carRepository.findByColor("White");
		
		assertThat(carList.contains(car));
	}
}
