package com.biddingsystem.model;

public class Products {
 
  private int productid;
  private String productname;
  private String productdescription;
  private String productcategory;
  private String starting_bp;
  private String bidtime;
  private String image;
  private int sellerid;

  

  public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}

public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }

  public String getProductdescription() {
    return productdescription;
  }

  public void setProductdescription(String productdescription) {
    this.productdescription = productdescription;
  }

  public String getProductcategory() {
    return productcategory;
  }

  public void setProductcategory(String productcategory) {
    this.productcategory = productcategory;
  }

  public String getStarting_bp() {
    return starting_bp;
  }

  public void setStarting_bp(String starting_bp) {
    this.starting_bp = starting_bp;
  }

  public String getBidtime() {
    return bidtime;
  }

  public void setBidtime(String bidtime) {
    this.bidtime = bidtime;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
  
  

public int getSellerid() {
	return sellerid;
}

public void setSellerid(int sellerid) {
	this.sellerid = sellerid;
}

@Override
public String toString() {
	return "Products [productid=" + productid + ", productname=" + productname + ", productdescription="
			+ productdescription + ", productcategory=" + productcategory + ", starting_bp=" + starting_bp
			+ ", bidtime=" + bidtime + ", image=" + image + ", sellerid=" + sellerid + "]";
}
  
  
  
}