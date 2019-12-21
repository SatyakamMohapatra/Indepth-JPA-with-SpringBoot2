package com.springjpa.basic.springbootjpabasic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.basic.springbootjpabasic.dao.PersonRepository;
import com.springjpa.basic.springbootjpabasic.model.Person;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findByID(Integer id) {
		return personRepository.findByID(id);
		
	}
	
	public void deleteByID(Integer id) {
		personRepository.deleteByID(id);
	}
	
	public Person add(Person person) {
		return personRepository.add(person);
		
	}
	
	public Person update(Person person) {
		return personRepository.add(person);
		
	}

}
