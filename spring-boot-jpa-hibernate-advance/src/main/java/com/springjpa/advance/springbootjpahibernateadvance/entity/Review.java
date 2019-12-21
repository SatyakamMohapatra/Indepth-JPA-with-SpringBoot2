package com.springjpa.advance.springbootjpahibernateadvance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ReviewRatting reviewRating;
	
	@ManyToOne
	private Course course;
	
	public Review() {	}

	
	public Review(String description, ReviewRatting reviewRating) {
		super();
		this.description = description;
		this.reviewRating = reviewRating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReviewRatting getRating() {
		return reviewRating;
	}

	public void setRating(ReviewRatting reviewRating) {
		this.reviewRating = reviewRating;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return String.format("Review [id=%s, description=%s, rating=%s]", id, description, reviewRating);
	}
}
