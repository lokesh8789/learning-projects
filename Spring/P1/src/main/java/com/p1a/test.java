package com.p1a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("com/p1a/conf.xml");
		Emp e1=(Emp) context.getBean("emp1");
		System.out.println(e1.getName());
		System.out.println(e1.getPhones());
		System.out.println(e1.getAddresses());
		System.out.println(e1.getCourses());
		System.out.println(e1.getProp());
	}
}
