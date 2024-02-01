package com.biddingsystem.model;

public class Transaction {
    private int sellerid;
	private String sname;
    private String scontact;
    private String saddress;
    private String semail;
    private String spassword;
    
  
    public int getSellerid() {
		return sellerid;
	}

	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}

	public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScontact() {
        return scontact;
    }

    public void setScontact(String scontact) {
        this.scontact = scontact;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }


	@Override
	public String toString() {
		return "Transaction [Seller_id=" + sellerid + ", sname=" + sname + ", scontact=" + scontact + ", saddress="
				+ saddress + ", semail=" + semail + ", spassword=" + spassword + "]";
	}
    
    
    
}
