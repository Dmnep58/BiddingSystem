package com.biddingsystem.model;

public class Bid {

	int pid;
	int sid;
	int bid;
	int bidamount;
	String status;
	String productname;
	
	
	
	
	
	
	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public int getPid() {
		return pid;
	}
	
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	public int getSid() {
		return sid;
	}
	
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	public int getBid() {
		return bid;
	}
	
	
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	public int getBidamount() {
		return bidamount;
	}
	
	
	public void setBidamount(int bidamount) {
		this.bidamount = bidamount;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Bid [pid=" + pid + ", sid=" + sid + ", bid=" + bid + ", bidamount=" + bidamount + ", status=" + status
				+ "]";
	}
	
	
	
	
}
