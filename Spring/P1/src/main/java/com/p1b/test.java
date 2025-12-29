package com.p1b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/p1b/conref.xml");
		A a=(A) context.getBean("aref");
		System.out.println(a.getX());
		System.out.println(a.getOb().getY());
		System.out.println(a);
	}

}
