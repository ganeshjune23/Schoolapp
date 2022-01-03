package com.example.Schoolapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Schoolapp.entity.Students;
import com.example.Schoolapp.repository.Studentrepo;

@Service
public class Studentservice {

	@Autowired
	private Studentrepo repo;

	public Students addStudent(Students student) {
		// TODO Auto-generated method stub

		return repo.save(student);

	}

	public String addStudents(List<Students> students) {
		// TODO Auto-generated method stub

		repo.saveAll(students);
		return "added many students";
	}

	public String deleteStudent(int roll) {
		// TODO Auto-generated method stub

		Students student = repo.getById(roll);
		repo.delete(student);
		return "Roll number is deleted : ";
	}

	public String updateStudent(Students student) {
		// TODO Auto-generated method stub

		repo.save(student);

		return "Roll number updated :"+student.getRoll();

	}

	public Students getStudent(int roll) {
		// TODO Auto-generated method stub

		return repo.findById(roll).get();
	}

}
