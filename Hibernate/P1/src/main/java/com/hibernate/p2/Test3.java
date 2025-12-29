package com.hibernate.p2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test3 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Q3 a=new Q3();
		Q3 b=new Q3();
		
		a.setQid(1);
		a.setQname("java");
		
		b.setQid(2);
		b.setQname("c++");
		
		A3 m=new A3();
		A3 n=new A3();
		
		m.setAid(22);
		m.setAname("wow");
		
		n.setAid(23);
		n.setAname("cool");
		
		List<Q3> list1=new ArrayList<Q3>();
		List<A3> list2=new ArrayList<A3>();
		
		list1.add(a);
		list1.add(b);
		
		list2.add(n);
		list2.add(m);
		
		a.setAns(list2);
		n.setQns(list1);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(a);
		s.save(b);
		s.save(m);
		s.save(n);
		tx.commit();
		s.close();
		
		factory.close();
	}

}
