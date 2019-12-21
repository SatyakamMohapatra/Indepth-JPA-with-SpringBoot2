package com.springjpa.advance.springbootjpahibernateadvance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "GET_ALL_COURSES", query = "select c from Course c") ,
		@NamedQuery(name = "GET_COURSE_WITH_NAME_A1", query = "select c from Course c where name like '%A1%'") 
		})
// Soft Delete: This will work for all queries except native Query where we have to add manualy
@SQLDelete(sql = "update course set is_deleted = true where id = ?")
@Where(clause = "is_deleted = fasle")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<Review>();

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "COURSE_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	@JsonIgnore
	private List<Student> students = new ArrayList<Student>();
	
	@Column(name = "is_deleted")
	private boolean isDeleted;

	public Course() {
	}

	public Course(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * When ever we delete this entity @SQLDelete will run and is_delete flag will be updated in db to be true
	 * but in java object isDelete instance variable will still be false.
	 * This method will update that instance variable
	 */
	@PreRemove
	private void updateIsDeleteFlag() {
		this.isDeleted = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review reviews) {
		this.reviews.remove(reviews);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s]", id, name);
	}

}
