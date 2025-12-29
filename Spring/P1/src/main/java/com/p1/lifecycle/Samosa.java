package com.p1.lifecycle;

public class Samosa {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("Setting samosa...");
	}

	public Samosa() {
		super();
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}
	public void init()
	{
		System.out.println("inside init samosa");
	}
	public void destroy()
	{
		System.out.println("inside destroy samosa");
	}
}
