package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//insert
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	//get single data
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class,studentId);
		return student;
	}
	//get all data
	public List<Student> getAllStudents()
	{
		List<Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	//update
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	//delete
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}
}
