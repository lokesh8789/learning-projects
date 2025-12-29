package com.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.p1.Student;

public class CriteriaAPI {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=factory.openSession();
		Criteria c=s.createCriteria(Student.class);
		//c.add(Restrictions.eq("city","mahuda"));
		c.add(Restrictions.gt("id", 102));
		List<Student> list=c.list();
		for(Student i:list)
		{
			System.out.println(i);
		}
	}

}
