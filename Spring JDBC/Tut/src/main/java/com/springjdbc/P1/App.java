package com.springjdbc.P1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.P1.dao.StudentDao;
import com.springjdbc.P1.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        //ApplicationContext con=new ClassPathXmlApplicationContext("com/springjdbc/P1/config.xml");
    	
    	ApplicationContext con=new AnnotationConfigApplicationContext(JdbcConfig.class);
    	
        /*
        JdbcTemplate temp=con.getBean("jdbcTemplate",JdbcTemplate.class);
       	// insert query
        String q="insert into student(id,name,city) values(?,?,?)";
        //fire query
        int result = temp.update(q,732,"Ankit","Bhagalpur");
        */
        StudentDao studentDao=(StudentDao) con.getBean("studentDao");
        
        /* inserting 
        Student student=new Student();
        student.setId(666);
        student.setName("john");
        student.setCity("london");
        int result=studentDao.insert(student);
        System.out.println("no of result inserted: "+result);*/
        
        /*updating
        Student s=new Student();
        s.setId(666);
        s.setName("ramesh");
        s.setCity("dhanbad");
        int r = studentDao.change(s);
        System.out.println("data changed: "+r );*/
        
        /*deleting
        int r = studentDao.delete(666);
        System.out.println("deleted: "+r);*/
        
        /*select single student data
        Student student = studentDao.getStudent(222);
        System.out.println(student);*/
        
        //select multiple student data
        List<Student> students = studentDao.getAllStudents();
        for(Student s:students)
        {
        	System.out.println(s.getId()+" : "+s.getName()+" : "+s.getCity());
        }
    }
}
