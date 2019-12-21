package com.springjpa.advance.springbootjpahibernateadvance.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Course;

@RepositoryRestResource(path = "resources")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	List<Course> findByNameAndId(String name,Long id);

	List<Course> findByName(String name);

	void deleteByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	@Query("select c from Course c where name like '%A1%'")
	List<Course> courseWithA1InName();

	@Query(value = "select * from course c where name like '%A1%'", nativeQuery = true)
	List<Course> courseWithA1InNameUsingNativeQuery();

	@Query(name = "GET_COURSE_WITH_NAME_A1")
	List<Course> courseWithA1InNameUsingNamedQuery();

}
