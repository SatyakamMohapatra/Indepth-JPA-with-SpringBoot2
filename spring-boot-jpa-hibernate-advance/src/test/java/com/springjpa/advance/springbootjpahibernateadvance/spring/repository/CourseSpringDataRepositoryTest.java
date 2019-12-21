package com.springjpa.advance.springbootjpahibernateadvance.spring.repository;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseSpringDataRepositoryTest {

	@Autowired
	private CourseSpringDataRepository courseRepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindAll() {
		List<Course> courses = courseRepository.findAll();
		courses.forEach(System.out::println);
	}

	@Test
	void testCreate() {
		courseRepository.save(new Course("A2.1"));
		List<Course> courses = courseRepository.findAll();
		courses.forEach(System.out::println);
	}

	@Test
	void testUpdate() {
		Course course = courseRepository.findById(10000l).get();
		course.setName("GERMAN A1 Updated");
		courseRepository.save(course);
		List<Course> courses = courseRepository.findAll();
		courses.forEach(System.out::println);
	}

	@Test
	void testDelete() {
		courseRepository.deleteById(10001l);
		List<Course> courses = courseRepository.findAll();
		courses.forEach(System.out::println);
	}
	
	@Test
	void testSort() {
		List<Course> courses = courseRepository.findAll(Sort.by(Direction.ASC,"name"));
		System.out.println("Sorted:  ");
		courses.forEach(System.out::println);
	}
	
	@Test
	void testPagination() {
		PageRequest pageRequest = PageRequest.of(0, 2);
		Page<Course> courses = courseRepository.findAll(pageRequest);
		System.out.println("page:  "+ courses.getContent());
	}

}
