package com.p1.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("com/p1/standalone/collections/colcon.xml");
		Person p=context.getBean("person1",Person.class);
		System.out.println(p);
		System.out.println(p.getFriends().getClass().getName());
		System.out.println(p.getFeestructure().getClass().getName());
	}

}
