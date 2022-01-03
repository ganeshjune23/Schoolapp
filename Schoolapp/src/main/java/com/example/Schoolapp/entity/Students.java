package com.example.Schoolapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "Students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roll;

	@NotNull(message = "city should not be null")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input")
	private String name;

	@NotNull(message = "city should not be null")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input")
	private String city;

	@Min(value=1,message="must be equal or greater than 1")
	@Max(value=99,message="must be equal or greater than 1")
  	private int age;

	public Students() {
	}

	public Students(int roll, String name, String city, int age) {
		super();
		this.roll = roll;
		this.name = name;
		this.city = city;
		this.age = age;
	}

	public int getRoll() {
		return roll;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
