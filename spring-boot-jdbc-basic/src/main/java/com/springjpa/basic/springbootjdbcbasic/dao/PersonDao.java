package com.springjpa.basic.springbootjdbcbasic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springjpa.basic.springbootjdbcbasic.model.Person;

@Repository
public class PersonDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//select * from person
	public List<Person> findAll() {
		List<Person> list= jdbcTemplate.query("select * from person", 
				new PersonRowMapper());
		return list;
	}
	
	public Person findByID(Integer id) {
		return jdbcTemplate
				.queryForObject("select * from person where id = ?",
						new Object[] {id},
						new PersonRowMapper());
		
	}
	
	public int deleteByID(Integer id) {
		return jdbcTemplate
				.update("delete from person where id = ?",
						new Object[] {id});
		
	}
	
	public int add(Person person) {
		return jdbcTemplate
				.update("insert into person (id,name,location,birth_date) "
						+ "values (?,?,?,?)",
						new Object[] {
								person.getId(),
								person.getName(),
								person.getLocation(),
								new Timestamp(person.getTimestamp().getTime())});
		
	}
	
	public int update(Person person) {
		return jdbcTemplate
				.update("update person "
						+ "set name = ?, location = ?, birth_date = ? "
						+ "Where id = ?",
						new Object[] {
								person.getName(),
								person.getLocation(),
								new Timestamp(person.getTimestamp().getTime()),
								person.getId()});
		
	}
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Person.Builder().id(rs.getInt("ID"))
								.name(rs.getString("NAME"))
								.timestamp(rs.getTimestamp("BIRTH_DATE"))
								.location(rs.getString("LOCATION"))
								.build();						
		}	
	}
}


