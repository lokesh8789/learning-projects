package com.hibernate.p2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class A3 {
	@Id
	private int aid;
	private String aname;
	@ManyToMany(mappedBy="ans")
	private List<Q3> qns;
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
	public List<Q3> getQns() {
		return qns;
	}
	public void setQns(List<Q3> qns) {
		this.qns = qns;
	}
}
