package com.springjdbc.P1.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.P1.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(Student student) {
		// insert query
        String q="insert into student(id,name,city) values(?,?,?)";
        int result = this.jdbcTemplate.update(q,student.getId(),student.getName(),student.getCity());
        return result;
	}
	
	public int change(Student student) {
		//update query
		String q="update student set name=?,city=? where id=?";
		int result = this.jdbcTemplate.update(q,student.getName(),student.getCity(),student.getId());
		return result;
	}
	public int delete(int studentId) {
		//delete query
		String q="delete from student where id=?";
		int r = this.jdbcTemplate.update(q,studentId);
		return r;
	}
	public Student getStudent(int studentId) {
		//select single student data
		String q="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(q,rowMapper,studentId);
		return student;
	}
	public List<Student> getAllStudents() {
		//select multiple data
		String q="select * from student";
		List<Student> students = this.jdbcTemplate.query(q,new RowMapperImpl());
		return students;
	}

}
