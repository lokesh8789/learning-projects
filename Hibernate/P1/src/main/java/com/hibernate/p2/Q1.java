package com.hibernate.p2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Q1 {
	@Id
	private int qid;
	private String qname;
	@OneToOne
	@JoinColumn(name="aid")
	private A1 ans;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public A1 getAns() {
		return ans;
	}
	public void setAns(A1 ans) {
		this.ans = ans;
	}
	public Q1(int qid, String qname, A1 ans) {
		super();
		this.qid = qid;
		this.qname = qname;
		this.ans = ans;
	}
	public Q1() {
		super();
	}
}
