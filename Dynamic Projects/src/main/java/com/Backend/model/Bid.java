package com.Backend.model;

import java.sql.Date;
import java.sql.Time;

public class Bid {
    private Long BidId;
    private String BidDay;
    private Date Day;
    private Time BidStartTime;
    private Time BidEndTime;
    private Long BidProductId;
    private Long BidAmount;
    private Long HighestBidAmount;

    
    public Long getBidId() {
        return BidId;
    }


    public void setBidId(Long BidId) {
        this.BidId = BidId;
    }


    public String getBidDay() {
        return BidDay;
    }


    public void setBidDay(String BidDay) {
        this.BidDay = BidDay;
    }


    public Date getDay() {
        return Day;
    }


    public void setDay(Date Day) {
        this.Day = Day;
    }


    public Time getBidStartTime() {
        return BidStartTime;
    }


    public void setBidStartTime(Time BidStartTime) {
        this.BidStartTime = BidStartTime;
    }


    public Time getBidEndTime() {
        return BidEndTime;
    }


    public void setBidEndTime(Time BidEndTime) {
        this.BidEndTime = BidEndTime;
    }


    public Long getBidProductId() {
        return BidProductId;
    }


    public void setBidProductId(Long BidProductId) {
        this.BidProductId = BidProductId;
    }


    public Long getBidAmount() {
        return BidAmount;
    }


    public void setBidAmount(Long BidAmount) {
        this.BidAmount = BidAmount;
    }


    public Long getHighestBidAmount() {
        return HighestBidAmount;
    }


    public void setHighestBidAmount(Long HighestBidAmount) {
        this.HighestBidAmount = HighestBidAmount;
    }

}
