package com.springjpa.advance.springbootjpahibernateadvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Review;

@Repository
@Transactional
public class ReviewRepository {
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	public Review findByID(Long id) {
		return em.find(Review.class, id);
	}
	
	public List<Review> findAll() {
		TypedQuery<Review> query = em.createNamedQuery("GET_ALL_COURSES",Review.class);
		return query.getResultList();
	}
	
	public void deleteByID(Long id) {
		Review course = findByID(id);
		em.remove(course);
	}
	
	public Review save(Review course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return em.merge(course);
	}
}
