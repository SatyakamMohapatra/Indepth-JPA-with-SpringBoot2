package com.springjpa.advance.hibernateinheritance.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpa.advance.hibernateinheritance.model.Employee;
import com.springjpa.advance.hibernateinheritance.model.FullTimeEmployee;
import com.springjpa.advance.hibernateinheritance.model.PartTImeEmployee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insertEmployee(Employee employee) {
		em.persist(employee);
	}
	
	public Employee getEmployee(Long employeeID) {
		return em.find(Employee.class, employeeID);
	}
	
	public List<Employee> getAllEmployee() {
		List<PartTImeEmployee> partTimeEmployee = em.createQuery("from PartTImeEmployee",PartTImeEmployee.class).getResultList();
		List<FullTimeEmployee> fullTimeEmployee = em.createQuery("from FullTimeEmployee",FullTimeEmployee.class).getResultList();
		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(fullTimeEmployee);
		employees.addAll(partTimeEmployee);
		return employees;
	}
}
