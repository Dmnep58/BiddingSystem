package com.Backend.model;

public class Product {
    private Long productId;
    private String productName;
    private String productDescription;
    private Long productAmount;
    private Long productSellerId;
    private String productImg;

    
    public Long getProductId() {
        return productId;
    }


    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getProductDescription() {
        return productDescription;
    }


    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public Long getProductAmount() {
        return productAmount;
    }


    public void setProductAmount(Long productAmount) {
        this.productAmount = productAmount;
    }


    public Long getProductSellerId() {
        return productSellerId;
    }

    public void setProductSellerId(Long productSellerId) {
        this.productSellerId = productSellerId;
    }


    public String getProductImg() {
        return productImg;
    }


    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

}
