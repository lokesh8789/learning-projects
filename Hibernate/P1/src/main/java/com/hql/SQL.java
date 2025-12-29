package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQL {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=factory.openSession();
		//sql
		String q="select * from student";
		NativeQuery nq=s.createSQLQuery(q);
		List<Object[]> list=nq.list();
		for(Object[] arr:list)
		{
			System.out.println(arr[4]+" "+arr[0]);
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		factory.close();
	}

}
