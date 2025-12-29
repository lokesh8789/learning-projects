package com.p1.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class A {
	//@Autowired
	//@Qualifier("address2")
	private Address address;

	public Address getAddress() {
		return address;
	}
	@Autowired
	@Qualifier("address2")
	public void setAddress(Address address) {
		this.address = address;
	}

	public A() {
		super();
	}

	@Override
	public String toString() {
		return "A [address=" + address + "]";
	}
	//@Autowired
	//@Qualifier("address2")
	public A(Address address) {
		super();
		this.address = address;
	}
}
