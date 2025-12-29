package com.p1.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean,DisposableBean {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("Setting pepsi");
	}

	public Pepsi() {
		super();
	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}

	public void destroy() throws Exception {
		System.out.println("inside destroy pepsi");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("inside init pepsi ");
		
	}
	
}
