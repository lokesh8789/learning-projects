package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.p1.Student;

public class HQL {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=factory.openSession();
		//hql
		//String q="from Student";
		//String q="from Student where city='dhanbad'";
		//String q="from Student where city=:x";
		String q="from Student as stu where stu.city=:x and stu.name=:n";
		Query query = s.createQuery(q);
		query.setParameter("x","mahuda");
		query.setParameter("n","lokesh");
		
		// single-uniqueResult
		//multiple- list
		List<Student> list=query.list();
		for(Student st:list)
		{
			System.out.println(st.getId());
		}
		System.out.println("---------------------------------------------");
		//Transaction tx=s.beginTransaction();
		/* delete query
		Query q2=s.createQuery("delete from Student where city=:x");
		q2.setParameter("x","bhagalpur");
		int r=q2.executeUpdate();
		System.out.println("deleted: "+r);
		*/
		/* update query
		Query q2=s.createQuery("update Student set city=:c where name=:n");
		q2.setParameter("c","mahuda");
		q2.setParameter("n", "lokesh");
		int r=q2.executeUpdate();
		System.out.println("updated: "+r);
		tx.commit();
		*/
		// joins query
		Query q2=s.createQuery("select q.qname,q.qid,a.aname from Q2 as q inner join q.ans as a");
		List<Object[]> list2=q2.list();
		for(Object[] arr:list2)
		{
			System.out.println(arr[0]);
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		factory.close();
	}
}
