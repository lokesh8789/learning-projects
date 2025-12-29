package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.p1.Student;

public class FirstLevel {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=factory.openSession();
		Student st=s.get(Student.class,102);
		System.out.println(st);
		System.out.println("checking...........");
		Student st1=s.get(Student.class, 102);
		System.out.println(st1);
		System.out.println(s.contains(st1));
		s.close();
		factory.close();
	}
}
