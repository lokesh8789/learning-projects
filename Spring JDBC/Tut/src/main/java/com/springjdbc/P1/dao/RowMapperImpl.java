package com.springjdbc.P1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.P1.entities.Student;

public class RowMapperImpl implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s=new Student();
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setCity(rs.getString(3));
		return s;
	}
	
}
