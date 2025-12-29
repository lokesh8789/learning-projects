package com.p1.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Value("#{22+11}")
	private int x;
	@Value("#{2}")
	private int y;
	@Value("#{T(java.lang.Math).sqrt(144)}")
	private double z;
	@Value("#{T(java.lang.Math).E}")
	private double w;
	@Value("#{new java.lang.String('Lokesh')}")
	private String name;
	@Value("#{8-4>3}")
	private boolean flag;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
	}
	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + ", name=" + name + ", flag=" + flag + "]";
	}
	
	
}
