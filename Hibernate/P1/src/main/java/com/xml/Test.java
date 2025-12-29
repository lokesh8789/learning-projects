package com.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Person p=new Person(23,"lokesh","dhanbad");
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(p);
		System.out.println(p);
		tx.commit();
		s.close();
		factory.close();

	}

}
