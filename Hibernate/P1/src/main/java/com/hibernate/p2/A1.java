package com.hibernate.p2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class A1 {
	@Id
	private int aid;
	private String aname;
	@OneToOne(mappedBy="ans")
	private Q1 qns;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Q1 getQns() {
		return qns;
	}
	public void setQns(Q1 qns) {
		this.qns = qns;
	}
	public A1(int aid, String aname, Q1 qns) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.qns = qns;
	}
	public A1() {
		super();
	}
	
}
