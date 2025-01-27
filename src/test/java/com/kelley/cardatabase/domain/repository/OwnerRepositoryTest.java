package com.kelley.cardatabase.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kelley.cardatabase.domain.model.Owner;

@DataJpaTest
public class OwnerRepositoryTest {
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Test
	void saveOwner() {
		ownerRepository.save(new Owner("Lucy", "Smith"));
		
		boolean ownerFound = false;
		
		Iterable<Owner> owners = ownerRepository.findByFirstName("Lucy");
		
		for (Owner owner : owners) {
			if ("Lucy".equals(owner.getFirstName()) && "Smith".equals(owner.getLastName())){
				ownerFound = true;
				break;
			}
		}
		
		assertThat(ownerFound).isTrue();
	}
	
	@Test
	void deleteOwners() {
		ownerRepository.save(new Owner("Lisa", "Morrison"));
		ownerRepository.deleteAll();
		assertThat(ownerRepository.count()).isEqualTo(0);
	}
}
