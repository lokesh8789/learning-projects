package com.hibernate.p2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Q1 a=new Q1();
		a.setQid(1);
		a.setQname("java");
		
		A1 m=new A1();
		m.setAid(22);
		m.setAname("cool");
		m.setQns(a);
		a.setAns(m);
		
		Q1 b=new Q1();
		b.setQid(2);
		b.setQname("c++");
		
		A1 n=new A1();
		n.setAid(23);
		n.setAname("cool");
		n.setQns(b);
		b.setAns(n);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(a);
		s.save(b);
		s.save(m);
		s.save(n);
		tx.commit();
		
		Q1 q1 = (Q1)s.get(Q1.class,1);
		System.out.println(q1.getQname());
		System.out.println(q1.getAns().getAname());
		
		s.close();
		
		
		factory.close();
	}

}
