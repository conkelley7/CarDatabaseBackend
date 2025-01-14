package com.kelley.cardatabase.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String brand;
	
	private String model;
	
	private String color;
	
	private String registrationNumber;
	
	private int modelYear;
	
	private int price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	@JsonManagedReference
	@JsonIgnore // Ignore during POST requests - allow NULL owners (add owners later through PUT request)
	@JsonProperty // Include during GET requests
	private Owner owner;
	
	// Constructors - Includes Default constructor for JPA/Hibernate
	public Car() {
	}
	
	public Car(String brand, String model, String color, String registrationNumber, int modelYear, int price, Owner owner) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.modelYear = modelYear;
		this.price = price;
		this.owner = owner;
	}
	
	// Only getter for Id - Primary key and do NOT want to change at any poiny.
	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
