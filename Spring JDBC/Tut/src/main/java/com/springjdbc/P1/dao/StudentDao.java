package com.springjdbc.P1.dao;

import java.util.List;

import com.springjdbc.P1.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
}
