package com.example.Schoolapp.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.Schoolapp.entity.Students;
import com.example.Schoolapp.service.Studentservice;

@Validated
@RestController
@RequestMapping("/v1")
public class Studentcontroller {

	@Autowired
	private Studentservice ser;

	@PostMapping("/add")
	public ResponseEntity<Students> addStudent(@Valid @RequestBody Students student) {

		Students stu = ser.addStudent(student);

		return new ResponseEntity<Students>(stu, HttpStatus.CREATED);

	}

	@PostMapping("/bulkAdd")
	public String addStudents(@RequestBody List<Students> student) {

		return ser.addStudents(student);

	}

	@DeleteMapping("all/{roll}")
	public String deleteStudent(@PathVariable int roll) {

		return ser.deleteStudent(roll);
	}

	@PutMapping("/add")
	public String updateStudent(@RequestBody Students student) {
		return ser.updateStudent(student);
	}

	@RequestMapping("/all/{roll}")
	public Students getStudent(@PathVariable int roll) {
		return ser.getStudent(roll);
	}

}
