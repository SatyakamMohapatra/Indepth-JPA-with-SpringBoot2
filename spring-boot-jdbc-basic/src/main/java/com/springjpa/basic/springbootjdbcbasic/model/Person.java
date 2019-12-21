package com.springjpa.basic.springbootjdbcbasic.model;

import java.util.Date;

public class Person {
	
	private Integer id;
	private String name;
	private Date timestamp;
	private String location;
	
	public Person(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.timestamp = builder.timestamp;
		this.location = builder.location;
	}

	public Person(Integer id, String name, Date timestamp, String location) {
		super();
		this.id = id;
		this.name = name;
		this.timestamp = timestamp;
		this.location = location;
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
}
