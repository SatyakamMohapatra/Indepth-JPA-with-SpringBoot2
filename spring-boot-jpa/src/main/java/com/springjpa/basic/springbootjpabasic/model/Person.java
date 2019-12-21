package com.springjpa.basic.springbootjpabasic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "find_all_person",query = "from Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date timestamp;
	
	private String location;
	
	public Person() {}
	
	public Person(Integer id, String name,String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Person(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.timestamp = builder.timestamp;
		this.location = builder.location;
	}
	
	public static class Builder{
		private Integer id;
		private String name;
		private Date timestamp;
		private String location;
		
		public Builder() {
			
		}
		
		public Builder id(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder timestamp(Date timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		public Builder location(String location) {
			this.location = location;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getLocation() {
		return location;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", timestamp=" + timestamp + ", location=" + location + "]";
	}
}
