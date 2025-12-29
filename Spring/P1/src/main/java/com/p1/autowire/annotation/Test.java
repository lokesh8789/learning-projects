package com.p1.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("com/p1/autowire/annotation/autocon.xml");
		A a=context.getBean("emp1",A.class);
		System.out.println(a);
	}
}
