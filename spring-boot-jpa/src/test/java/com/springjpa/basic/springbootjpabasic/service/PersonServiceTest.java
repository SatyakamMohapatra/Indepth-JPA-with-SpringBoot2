package com.springjpa.basic.springbootjpabasic.service;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springjpa.basic.springbootjpabasic.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonServiceTest {
	
	@Autowired
	PersonService  PersonService;
	private List<Person> persons = null;
	
	@BeforeEach
	void setUp() throws Exception {
		persons = PersonService.findAll();
	}

	@Test
	void findAllTest() {
		Assert.assertNotNull(persons);
	}
	
	@Test
	void findByIDTest() {
		Person person = PersonService.findByID(persons.get(0).getId());
		Assert.assertNotNull(person);
	}
	
	@Test()
	void deleteByIDTest() {
		int id = persons.get(1).getId();
		PersonService.deleteByID(id);
		PersonService.findByID(id);
	}
	
	@Test
	void addTest() {
		Person person = PersonService.add(new Person(10010,"Tim","Aus"));
		Assert.assertTrue(person.getName().equalsIgnoreCase("Tim"));
	}

}
