package com.hibernate.p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embed {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student s=new Student();
		s.setId(104);
		s.setName("ramesh");
		s.setCity("mahuda");
		
		Certi c=new Certi();
		c.setCourse("java");
		c.setDuration("2mon");
		s.setCerti(c);
		
		Student s1=new Student();
		s1.setId(105);
		s1.setName("ram");
		s1.setCity("mahuda");
		
		Certi c1=new Certi();
		c1.setCourse("c++");
		c1.setDuration("2mon");
		s1.setCerti(c1);
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(s);
		session.save(s1);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
