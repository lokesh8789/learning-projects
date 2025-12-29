package com.hibernate.p2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class A2 {
	@Id
	private int aid;
	private String aname;
	@ManyToOne
	private Q2 qns;
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
	public Q2 getQns() {
		return qns;
	}
	public void setQns(Q2 qns) {
		this.qns = qns;
	}
}
