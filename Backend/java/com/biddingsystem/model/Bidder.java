package com.biddingsystem.model;

public class Bidder {

	private int bidderid;
    private String name;
    private String email;
    private long contact;
    private String password;
    

    
    public int getBidderid() {
		return bidderid;
	}

	public void setBidderid(int Bidderid) {
		this.bidderid = Bidderid;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public void setContact(long l) {
        this.contact = l;
    }
    
    public Long getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    
}