package com.springjpa.advance.springbootjpahibernateadvance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Course;
import com.springjpa.advance.springbootjpahibernateadvance.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	public Course findByID(Long id) {
		return courseRepo.findByID(id);
	}
	
	public List<Course> findAll() {
		return courseRepo.findAll();
	}
	
	public void deleteByID(Long id) {
		courseRepo.deleteByID(id);
	}
	
	public Course save(Course course) {
		return courseRepo.save(course);
	}

}
