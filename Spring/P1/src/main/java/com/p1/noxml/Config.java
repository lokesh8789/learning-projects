package com.p1.noxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.p1.noxml")
public class Config {
	@Bean
	public Samosa getSamosa()
	{
		return new  Samosa();
	}
	@Bean(name= {"e1","e2","e3"})
	public Emp getEmp()
	{
		/*Emp e=new Emp();   setter injection way
		e.setSamosa(getSamosa());*/
		return new Emp(getSamosa());  //constructor injection way
	}
}
