package com.hibernate.p2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Q3 {
	@Id
	private int qid;
	private String qname;
	@ManyToMany
	@JoinTable(name="newtable",joinColumns= {@JoinColumn(name="qid")},inverseJoinColumns= {@JoinColumn(name="aid")})
	private List<A3> ans;
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
	public List<A3> getAns() {
		return ans;
	}
	public void setAns(List<A3> ans) {
		this.ans = ans;
	}
}
