package com.p1.noxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext con=new AnnotationConfigApplicationContext(Config.class);
		Student s=con.getBean("st",Student.class);
		s.study();
		Emp e=con.getBean("e2",Emp.class);
		e.work();
	}

}
