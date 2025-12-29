package com.p1.autowire;

public class A {
	private Address address;

	public Address getAddress() {
		return address;
	}

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

	public A(Address address) {
		super();
		this.address = address;
	}
}
