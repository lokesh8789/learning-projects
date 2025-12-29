package com.hibernate.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		
		//get student data
		Student student = (Student)session.get(Student.class,103);
		System.out.println(student);
		Student student1 = (Student)session.load(Student.class,102);
		System.out.println(student1);
		
		Address a=(Address)session.get(Address.class,2);
		System.out.println(a.getCity());
		session.close();
		
		factory.close();
	}

}
