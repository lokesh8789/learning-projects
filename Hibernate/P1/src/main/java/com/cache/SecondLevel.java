package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.p1.Student;

public class SecondLevel {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s1=factory.openSession();
		Student st1=s1.get(Student.class,102);
		System.out.println(st1);
		s1.close();
		Session s2=factory.openSession();
		Student st2=s2.get(Student.class,102);
		System.out.println(st2);
		s2.close();
		factory.close();
	}

}
