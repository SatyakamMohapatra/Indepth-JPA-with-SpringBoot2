package com.springjpa.advance.springbootjpahibernateadvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
class CriteriaJpqlTest {

	@Autowired
	@PersistenceContext
	private EntityManager em;

	@BeforeEach
	void setUp() throws Exception {
	}

	// Get ALL
	@Test
	@Transactional
	void jpql_criteria__all_course() {

		// "Select c from Course c"
		// 1. Use Criteria Builder to create a Criteria Query returning the expected
		// result object

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Defined roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates etc to the criteria query
		// 4. Add predicates etc to the criteria query
		// 5. Build the TypedQuery using the entity manager and criteria quere
		TypedQuery<Course> typedQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = typedQuery.getResultList();
		System.out.println("Test jpql_criteria__all_course -> " + resultList);
	}

	// Get ALL
	@Test
	@Transactional
	void jpql_criteria_name_like() {
		// "Select c from Course c where name like "%A1%"

		// 1. Use Criteria Builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Defined roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates etc to the criteria query
		Predicate likeA1 = cb.like(courseRoot.get("name"), "%A1%");
		cq.where(likeA1);

		// 4. Add predicates etc to the criteria query

		// 5. Build the TypedQuery using the entity manager and criteria quere
		TypedQuery<Course> typedQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = typedQuery.getResultList();
		System.out.println("Test jpql_criteria_name_like -> " + resultList);
	}

	// without student
	@Test
	@Transactional
	void jpql_criteria_without_student() {
		// "Select c from Course c where name like "%A1%"

		// 1. Use Criteria Builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Defined roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates etc to the criteria query
		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
		cq.where(studentsIsEmpty);

		// 4. Add predicates etc to the criteria query

		// 5. Build the TypedQuery using the entity manager and criteria quere
		TypedQuery<Course> typedQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = typedQuery.getResultList();
		System.out.println("Test jpql_criteria_without_student -> " + resultList);
	}
	
	//JOIN
	@Test
	@Transactional
	void jpql_criteria_join() {
		// "Select c , s from Course c join c.student s"

		// 1. Use Criteria Builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Defined roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates etc to the criteria query
		Join<Object, Object> join = courseRoot.join("students");

		// 4. Add predicates etc to the criteria query

		// 5. Build the TypedQuery using the entity manager and criteria quere
		TypedQuery<Course> typedQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = typedQuery.getResultList();
		System.out.println("Test jpql_criteria_join -> " + resultList);
	}
	
	//JOIN
	@Test
	@Transactional
	void jpql_criteria_left_join() {
		// "Select c , s from Course c join c.student s"

		// 1. Use Criteria Builder to create a Criteria Query returning the expected
		// result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2. Defined roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3. Define predicates etc to the criteria query
		Join<Object, Object> join = courseRoot.join("students",JoinType.LEFT);

		// 4. Add predicates etc to the criteria query

		// 5. Build the TypedQuery using the entity manager and criteria quere
		TypedQuery<Course> typedQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = typedQuery.getResultList();
		System.out.println("Test jpql_criteria_left_join -> " + resultList);
	}

}
