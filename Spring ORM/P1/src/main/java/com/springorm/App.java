package com.springorm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) con.getBean("studentDao");
        /* create/insert
        Student student=new Student(24,"subham","dhanbad");
        int i = studentDao.insert(student);
        System.out.println(i);
        */
        /*get/read
        Student student = studentDao.getStudent(23);
        System.out.println(student.getStudentName());
        
        //readAll
        List<Student> students = studentDao.getAllStudents();
        for(Student s:students)
        {
        	System.out.println(s.getStudentName()+" "+s.getStudentCity());
        }
        */
        /*update
        Student student=new Student(24,"ramesh","mahuda");
        studentDao.updateStudent(student);
        List<Student> students = studentDao.getAllStudents();
        for(Student s:students)
        {
        	System.out.println(s.getStudentName()+" "+s.getStudentCity());
        }
        */
        //studentDao.deleteStudent(24);
        List<Student> students = studentDao.getAllStudents();
        for(Student s:students)
        {
        	System.out.println(s.getStudentName()+" "+s.getStudentCity());
        }
        Student student = studentDao.getStudent(24);
        System.out.println(student);
    }
}
