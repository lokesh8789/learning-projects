package com.p1.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext con=new ClassPathXmlApplicationContext("com/p1/spel/consl.xml");
		Demo d1=con.getBean("demo",Demo.class);
		System.out.println(d1);
		SpelExpressionParser temp=new SpelExpressionParser();
		Expression exp=temp.parseExpression("22+44");
		System.out.println(exp.getValue());
	}
}
