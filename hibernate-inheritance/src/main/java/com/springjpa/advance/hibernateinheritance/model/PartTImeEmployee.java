package com.springjpa.advance.hibernateinheritance.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTImeEmployee extends Employee{
	
	private BigDecimal hourlyWages;

	public PartTImeEmployee() {	}

	public PartTImeEmployee(String name, BigDecimal hourlyWages) {
		super(name);
		this.setHourlyWages(hourlyWages);
	}

	public BigDecimal getHourlyWages() {
		return hourlyWages;
	}

	public void setHourlyWages(BigDecimal hourlyWages) {
		this.hourlyWages = hourlyWages;
	}
	
}
