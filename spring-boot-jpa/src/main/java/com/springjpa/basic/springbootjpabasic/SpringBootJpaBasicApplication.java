package com.springjpa.basic.springbootjpabasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.basic.springbootjpabasic.model.Person;
import com.springjpa.basic.springbootjpabasic.service.PersonService;

@SpringBootApplication
public class SpringBootJpaBasicApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonService personService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All User : {}",personService.findAll());
		logger.info("User id 10001 : {}",personService.findByID(10001));
		logger.info("Adding User id 10005 : {}",personService.add(new Person(10005,"Tim", "london")));
		personService.deleteByID(10001);
		logger.info("Updating id 10002 : {}",personService.add(new Person(10002,"Tim","Aus")));
	}

}
