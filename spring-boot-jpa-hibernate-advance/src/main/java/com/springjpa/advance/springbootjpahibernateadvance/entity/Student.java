package com.springjpa.advance.springbootjpahibernateadvance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "GET_ALL_STUDENT", query = "Select s from Student s")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne
	private Passport passport;
	
	@Embedded
	private Address address;
	
	@ManyToMany(mappedBy = "students")
	private List<Course> course = new ArrayList<Course>();
	
	public Student() {	}

	public Student(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	public List<Course> getCourse() {
		return course;
	}

	public void addCourse(Course course) {
		this.course.add(course);
	}
	
	public void removeCourse(Course course) {
		this.course.remove(course);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s, passport=%s]", id, name, passport);
	}

}
