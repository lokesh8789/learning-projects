package com.p1.noxml;

public class Emp {
	private Samosa samosa;
	public Emp() {
		super();
	}
	public Emp(Samosa samosa) {
		super();
		this.samosa = samosa;
	}
	public Samosa getSamosa() {
		return samosa;
	}
	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}
	public void work()
	{
		this.samosa.disp();
		System.out.println("working....");
	}
}
