package com.springjpa.advance.springbootjpahibernateadvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	public Student findByID(Long id) {
		return em.find(Student.class, id);
	}
	
	public List<Student> findAll() {
		TypedQuery<Student> query = em.createNamedQuery("GET_ALL_STUDENT",Student.class);
		return query.getResultList();
	}
	
	public void deleteByID(Long id) {
		Student student = findByID(id);
		em.remove(student);
	}
	
	public Student save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}
}
