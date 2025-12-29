package com.p1.constructor;

public class Addition {
	private int a;
	private int b;
	Addition(int a,int b)
	{
		this.a=a;
		this.b=b;
		System.out.println("int int");
	}
	Addition(double a ,double b)
	{
		this.a=(int) a;
		this.b=(int) b;
		System.out.println("double double");
	}
	Addition(String a,String b)
	{
		this.a=Integer.parseInt(a);
		this.b=Integer.parseInt(b);
		System.out.println("String String");
	}
	void sum()
	{
		System.out.println("a is: "+a);
		System.out.println("b is: "+b);
		System.out.println(a+b);
	}
}
