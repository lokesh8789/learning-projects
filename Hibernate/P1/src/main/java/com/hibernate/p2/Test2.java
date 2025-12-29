package com.hibernate.p2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Q2 a=new Q2();
		a.setQid(1);
		a.setQname("java");
		
		A2 m=new A2();
		m.setAid(22);
		m.setAname("cool");
		m.setQns(a);
		
		
		A2 n=new A2();
		n.setAid(23);
		n.setAname("wow");
		n.setQns(a);
		List<A2> list=new ArrayList<A2>();
		list.add(n);
		list.add(m);
		
		a.setAns(list);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(a);
		s.save(m);
		s.save(n);
		tx.commit();
		Q2 q=(Q2)s.get(Q2.class,1);
		System.out.println(q.getQname());
		for(A2 an:q.getAns())
		{
			System.out.println(an.getAname());
		}
		s.close();
		
		factory.close();
	}

}
