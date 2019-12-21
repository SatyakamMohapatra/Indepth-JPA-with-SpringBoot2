package com.springjpa.advance.springbootjpahibernateadvance.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Course;
import com.springjpa.advance.springbootjpahibernateadvance.services.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private CourseService courseRepoService;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	public void findByIDTest() {
		assertEquals("GERMAN A1", courseRepo.findByID(1000l).getName());
	}

	@Test
	public void findAllTest() {
		assertNotNull(courseRepo.findAll());
	}

	@Test
	@DirtiesContext
	public void deleteByIDTest() {
		courseRepoService.deleteByID(1000l);
		assertNull(courseRepo.findByID(1000l));
	}

	@Test
	@DirtiesContext
	public void addTest() {
		Course course = new Course("German C1");
		courseRepoService.save(course);
		List<Course> resultCourse = courseRepo.findAll().stream()
				.filter(el -> el.getName().equalsIgnoreCase("German C1")).collect(Collectors.toList());
		assertEquals("German C1", resultCourse.get(0).getName());

	}

	@Test
	@DirtiesContext
	public void updateTest() {
		Course course = courseRepo.findByID(1000l);
		course.setName("German B1-2");
		courseRepoService.save(course);
		assertEquals("German B1-2", courseRepo.findByID(1000l).getName());
	}

}
