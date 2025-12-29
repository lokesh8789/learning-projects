package com.hibernate.p2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Q2 {
	@Id
	private int qid;
	private String qname;
	@OneToMany(mappedBy="qns",fetch=FetchType.EAGER)
	private List<A2> ans;
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
	public List<A2> getAns() {
		return ans;
	}
	public void setAns(List<A2> ans) {
		this.ans = ans;
	}
}
