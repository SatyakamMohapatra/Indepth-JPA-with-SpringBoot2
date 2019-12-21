package com.springjpa.basic.springbootjpabasic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.springjpa.basic.springbootjpabasic.model.Person;

@Repository
public class PersonRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Person> findAll() {
		TypedQuery<Person> query = entityManager.createNamedQuery("find_all_person",Person.class);
		return query.getResultList();
	}
	
	public Person findByID(Integer id) {
		return entityManager.find(Person.class, id);
		
	}
	
	public void deleteByID(Integer id) {
		Person person = findByID(id);
		entityManager.remove(person);
		
	}
	
	public Person add(Person person) {
		return entityManager.merge(person);
		
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
		
	}
}


