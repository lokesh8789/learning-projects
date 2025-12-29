package com.p1.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/p1/lifecycle/conl.xml");
		context.registerShutdownHook();
		Samosa s=(Samosa) context.getBean("sam");
		System.out.println(s);
		Pepsi p=(Pepsi) context.getBean("pep");
		System.out.println(p);
		Example e=(Example) context.getBean("exm");
		System.out.println(e);
	}

}
