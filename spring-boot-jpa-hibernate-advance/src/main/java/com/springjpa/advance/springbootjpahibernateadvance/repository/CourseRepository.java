package com.springjpa.advance.springbootjpahibernateadvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Course;
import com.springjpa.advance.springbootjpahibernateadvance.entity.Review;
import com.springjpa.advance.springbootjpahibernateadvance.entity.Student;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	public Course findByID(Long id) {
		return em.find(Course.class, id);
	}
	
	public List<Course> findAll() {
		TypedQuery<Course> query = em.createNamedQuery("GET_ALL_COURSES",Course.class);
		return query.getResultList();
	}
	
	public void deleteByID(Long id) {
		Course course = findByID(id);
		em.remove(course);
	}
	
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return em.merge(course);
	}
	
	public void addReviewsToCourse(Long id, List<Review> reviews) {
		Course course = findByID(id);
		reviews.stream().forEach(review -> settingUpCourseAndReviewRelation(course, review));
	}

	private void settingUpCourseAndReviewRelation(Course course, Review review) {
		course.addReview(review);
		review.setCourse(course);
		em.persist(review);
	}
	
	public void addStudents(Long id, Student student) {
		Course course = findByID(id);
		course.addStudent(student);
		student.addCourse(course);
		em.persist(course);
		
	}
}
