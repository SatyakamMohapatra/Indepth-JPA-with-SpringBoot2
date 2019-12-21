package com.springjpa.advance.springbootjpahibernateadvance.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpa.advance.springbootjpahibernateadvance.entity.Passport;

@Repository
@Transactional
public class PassportRepository {
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	public Passport findByID(Long id) {
		return em.find(Passport.class, id);
	}
	
	public List<Passport> findAll() {
		TypedQuery<Passport> query = em.createNamedQuery("GET_ALL_PASSPORT",Passport.class);
		return query.getResultList();
	}
	
	public void deleteByID(Long id) {
		Passport passport = findByID(id);
		em.remove(passport);
	}
	
	public Passport save(Passport passport) {
		if (passport.getId() == null) {
			em.persist(passport);
		} else {
			em.merge(passport);
		}
		return passport;
	}
}
