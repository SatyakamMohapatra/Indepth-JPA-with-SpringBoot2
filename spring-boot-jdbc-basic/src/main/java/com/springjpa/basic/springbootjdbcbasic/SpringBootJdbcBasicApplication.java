package com.springjpa.basic.springbootjdbcbasic;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.basic.springbootjdbcbasic.dao.PersonDao;
import com.springjpa.basic.springbootjdbcbasic.model.Person;

@SpringBootApplication
public class SpringBootJdbcBasicApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All User : {}",dao.findAll());
		logger.info("User id 10001 : {}",dao.findByID(10001));
		logger.info("Delete User id 10001 : {}",dao.deleteByID(10002));
		logger.info("Adding User id 10005 : {}",dao.add(new Person(10004,"Tim",new Date(System.currentTimeMillis()),"london")));
		logger.info("Updating id 10002 : {}",dao.add(new Person(10002,"Tim",new Date(System.currentTimeMillis()),"Aus")));
	}

}
