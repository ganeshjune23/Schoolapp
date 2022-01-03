package com.example.Schoolapp;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Schoolapp.entity.Students;
import com.example.Schoolapp.repository.Studentrepo;
import com.example.Schoolapp.service.Studentservice;


@RunWith(SpringRunner.class)
@SpringBootTest
public class jnittest extends Exception{


	@Autowired
	private Studentrepo repo;

	@Autowired
	private Studentservice ser;
	
	@Test
	public void addStudentTest() {
	Students st=new Students();
	st.setName("Ganesh");
	st.setCity("Haveri");
	st.setAge(20);
	repo.save(st);
	assertNotNull(repo.findAll());
	
	}
	
	@Test
	@Rollback(false)
	public void testUpdate() {
		Students stud=repo.findById(1).get();
		stud.setName("Gani");
		repo.save(stud);
		assertNotEquals("Ganesh", repo.findById(1).get().getName());
		
	}
	
	@Test
	public void getStudent()
	{
		Students student=repo.findById(1).get();
		Assertions.assertThat(student.getRoll()).isEqualTo(1);
	}
	
}
