package com.Backend.model;

public class seller {
    private Long sellerId;
    private String sellerName;
    private String sellerAddress;
    private String sellerEmail;
    private Long sellerContact;
    private String sellerImg;
    private String sellerPassword;

    
    public Long getSellerId() {
        return sellerId;
    }


    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }


    public String getSellerName() {
        return sellerName;
    }


    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }


    public String getSellerAddress() {
        return sellerAddress;
    }


    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }


    public String getSellerEmail() {
        return sellerEmail;
    }


    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }


    public Long getSellerContact() {
        return sellerContact;
    }


    public void setSellerContact(Long sellerContact) {
        this.sellerContact = sellerContact;
    }

    public String getSellerImg() {
        return sellerImg;
    }

    public void setSellerImg(String sellerImg) {
        this.sellerImg = sellerImg;
    }

    
    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

}
