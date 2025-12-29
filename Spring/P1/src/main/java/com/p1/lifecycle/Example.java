package com.p1.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
		System.out.println("setting example");
	}

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Example [subject=" + subject + "]";
	}
	@PostConstruct
	public void init()
	{
		System.out.println("inside init example");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("inside destroy example");
	}
}
