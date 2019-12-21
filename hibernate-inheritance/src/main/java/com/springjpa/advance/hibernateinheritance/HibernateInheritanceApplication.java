package com.springjpa.advance.hibernateinheritance;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.advance.hibernateinheritance.model.Employee;
import com.springjpa.advance.hibernateinheritance.model.FullTimeEmployee;
import com.springjpa.advance.hibernateinheritance.model.PartTImeEmployee;
import com.springjpa.advance.hibernateinheritance.repository.EmployeeRepository;

@SpringBootApplication
public class HibernateInheritanceApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateInheritanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.insertEmployee(new FullTimeEmployee("Satya", new BigDecimal(100400)));
		employeeRepository.insertEmployee(new PartTImeEmployee("Raj",new BigDecimal(567)));
		System.out.println(employeeRepository.getAllEmployee());
	}

}
