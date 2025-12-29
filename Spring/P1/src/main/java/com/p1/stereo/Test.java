package com.p1.stereo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext con=new ClassPathXmlApplicationContext("com/p1/stereo/const.xml");
		Student s=(Student) con.getBean("student");
		System.out.println(s);
		Student s1=con.getBean("student",Student.class);
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		Wow wow1=con.getBean("w1",Wow.class);
		Wow wow2=con.getBean("w1",Wow.class);
		System.out.println(wow1.hashCode());
		System.out.println(wow2.hashCode());
	}

}
