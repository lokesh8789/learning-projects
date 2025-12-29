package com.p1.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/p1/constructor/conc.xml"); 
		Person p=(Person) context.getBean("person");
		System.out.println(p);
		Addition a=(Addition) context.getBean("add");
		a.sum();
	}

}
