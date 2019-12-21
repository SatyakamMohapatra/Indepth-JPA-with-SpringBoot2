package com.springjpa.advance.springbootjpahibernateadvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Course;
import com.springjpa.advance.springbootjpahibernateadvance.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpqlTest {
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	//not in
	@Test
	@Transactional
	void jpql_course_without_student() {
		TypedQuery<Course> typedQuery = em.createQuery("Select c from Course c where c.students is empty",Course.class);
		System.out.println("Test jpql_course_without_student -> "+typedQuery.getResultList());
	}
	
	//count
	@Test
	@Transactional
	void jpql_course_with_more_then_2_student() {
		TypedQuery<Course> typedQuery = em.createQuery("Select c from Course c where size(c.students) >= 2",Course.class);
		System.out.println("Test jpql_course_with_more_then_2_student -> "+typedQuery.getResultList());
	}
	
	//order by
	@Test
	@Transactional
	void jpql_order_by_student_count() {
		TypedQuery<Course> typedQuery = em.createQuery("Select c from Course c order by size(c.students)",Course.class);
		System.out.println("Test jpql_order_by_student_count -> "+typedQuery.getResultList());
	}
	
	//order by
	@Test
	@Transactional
	void jpql_like_pasport_name_in_course() {
		TypedQuery<Student> typedQuery = em.createQuery("Select s from Student s where s.passport.number like '%HJ%'",Student.class);
		System.out.println("Test jpql_like_pasport_name_in_course -> "+typedQuery.getResultList());
	}
		
	//between 100 and 1000
	//is null
	//upper, lower, trim, length
		
	//JOIN => select c, s from Course c JOIN c.students s
	//LEFT JOIN => select c, s from Course c LEFT JOIN c.students s
	//CROSS JOIN => select c, s from Course c,c.students s
	
	//JOIN
	@Test
	@Transactional
	void jpql_join() {
		Query query = em.createQuery("select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("Test jpql_join \n");
		resultList.forEach(el -> {
			System.out.println("jpql_join 1 -> " +el[0]);
			System.out.println("jpql_join 1 -> " +el[1]);
		});
	}
	
	//LEFT JOIN
	@Test
	@Transactional
	void jpql_left_join() {
		Query query = em.createQuery("select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("Test jpql_left_join \n");
		resultList.forEach(el -> {
			System.out.println("jpql_left_join 1 -> " +el[0]);
			System.out.println("jpql_left_join 1 -> " +el[1]);
		});
	}
	
	//CROSS JOIN
	@Test
	@Transactional
	void jpql_cross_join() {
		Query query = em.createQuery("select c, s from Course c,Student s");
		List<Object[]> resultList = query.getResultList();
		System.out.println("Test jpql_cross_join \n");
		resultList.forEach(el -> {
			System.out.println("jpql_cross_join 1 -> " +el[0]);
			System.out.println("jpql_cross_join 1 -> " +el[1]);
		});
	}
}
