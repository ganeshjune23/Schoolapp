package com.example.Schoolapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Schoolapp.entity.Students;
import com.example.Schoolapp.repository.Studentrepo;
import com.example.Schoolapp.service.Studentservice;

@RunWith(SpringRunner.class)
@SpringBootTest
class SchoolappApplicationTests {

	@Autowired
	private Studentrepo repo;

	@Autowired
	private Studentservice ser;
	
	@Test
	void addStudentTest() {
		Students st = new Students();
		st.setName("Ganesh");
		st.setCity("Haveri");
		st.setAge(20);
		repo.save(st);
		assertNotNull(repo.findAll());

	}

	@Test
	@Rollback(false)
	void testUpdate() {
		Students stud = repo.findById(1).get();
		stud.setName("Gani");
		repo.save(stud);
		assertNotEquals("Ganesh", repo.findById(1).get().getName());

	}

	@Test
	void getStudent() {
		Students student = repo.findById(1).get();
		Assertions.assertThat(student.getRoll()).isEqualTo(1);
	}
	
	
	
//	@Test
//	void whenGivenId_shouldDeleteUser_ifFound(){
//		Students user = new Students(1,"Gan","hav");
//		
//		user.setRoll(1);
//		when(repo.findById(user.getRoll())).thenReturn(Optional.of(user));
//		ser.deleteStudent(user.getRoll());
//		verify(repo).deleteById(user.getRoll());
//		}
}

//Product product = repo.findByName("iPhone 10");
//
//repo.deleteById(product.getId());
// 
//Product deletedProduct = repo.findByName("iPhone 10");
// 
//assertThat(deletedProduct).isNull();       



//package com.example.Schoolapp;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.Schoolapp.controller.Studentcontroller;
//import com.example.Schoolapp.entity.Students;
//import com.example.Schoolapp.repository.Studentrepo;
//import com.example.Schoolapp.service.Studentservice;
//import com.google.common.base.Optional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class SchoolappApplicationTests {
//
//	
//	@Autowired
//	private Studentservice ser;
//	
//		
//	@MockBean
//	private Studentrepo  repo;
//	
//	@Mock
//	Students user;
//	
//	
//	
//	
//	
//	
//	
//@Test
//void addStudent()
//{
//	Students stud=new Students(1,"Ganesh","Haveri",12);
//	
//	when(repo.save(stud)).thenReturn(stud);
//	
//	assertEquals(stud, ser.addStudent(stud));
//
//}
//
//
//
//@Test
//void deleteStudent()
//{
//	Students stud = new Students(1, "Pranya", "Pune",33);
//	ser.deleteUser(stud);
//	verify(repo, times(1)).delete(stud);
//
//	
//
//}
//
//	@Test
//	void getStudentTest() {
//	when(repo.findAll()).thenReturn(Stream
//			.of(new Students(376, "Danile", "USA",22), new Students(958, "Huy", "UK",23)).collect(Collectors.toList()));
//	assertEquals(2, ser.getStudents().size());
//}
//	
//	
//	
//	@Test
//	 void updateTest()
//	 {
//		Students stu=mock(Students.class);
//		when(stu.getRoll()).thenReturn(1);
//		when(stu.getName()).thenReturn("Ganesh");
//		when(stu.getCity()).thenReturn("Haveri");
//		when(stu.getAge()).thenReturn(22);
//		ser.updateStudent(stu);
//		verify(repo).save(stu);
//		
//	 }
//
//}
//	
//
///*
//@Test
//void addStudentTest() {
//Students st=new Students();
//st.setName("Ganesh");
//st.setCity("Haveri");
//st.setAge(20);
//repo.save(st);
//assertNotNull(repo.findAll());
//
//}
//
//@Test
//@Rollback(false)
//void testUpdate() {
//	Students stud=repo.findById(1).get();
//	stud.setName("Gani");
//	repo.save(stud);
//	assertNotEquals("Ganesh", repo.findById(1).get().getName());
//	
//}
//
//@Test
//void getStudent()
//{
//	Students student=repo.findById(1).get();
//	Assertions.assertThat(student.getRoll()).isEqualTo(1);
//}
//	
//}
//*/
//
//	