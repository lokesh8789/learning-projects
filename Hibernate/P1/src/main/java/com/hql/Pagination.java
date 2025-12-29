package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.p1.Student;

public class Pagination {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=factory.openSession();
		Query<Student> q=s.createQuery("from Student",Student.class);
		q.setFirstResult(0);
		q.setMaxResults(2);
		List<Student> list=q.list();
		for(Student st:list)
		{
			System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
		}
		s.close();
		factory.close();
	}

}
