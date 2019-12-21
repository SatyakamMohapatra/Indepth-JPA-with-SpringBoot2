package com.springjpa.advance.springbootjpahibernateadvance.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Course;
import com.springjpa.advance.springbootjpahibernateadvance.entity.Passport;
import com.springjpa.advance.springbootjpahibernateadvance.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Transactional
	void fatchStudentWithPassport() {
		Student student = studentRepository.findByID(40002l);
		System.out.println(student);
		System.out.println(student.getPassport());
	}
	
	@Test
	@Transactional
	void transctionalTest() {
		Student student = studentRepository.findByID(40002l);
		Passport passport = student.getPassport();
		
		passport.setNumber("213EBIFFS");
		student.setName("John Updated");
		
		System.out.println(student);
		System.out.println(student.getPassport());
	}
	
	@Test
	@Transactional
	void transctionalTest2() {

		
	}

}
