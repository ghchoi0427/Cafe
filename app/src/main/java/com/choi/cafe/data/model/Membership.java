package com.choi.cafe.data.model;

public class Membership {

    private String membershipID;
    private String membershipPoint;
    private Customer owner;

    public Membership(){}
    public Membership(String membershipID, String membershipPoint, Customer owner) {
        this.membershipID = membershipID;
        this.membershipPoint = membershipPoint;
        this.owner = owner;
    }

    public String getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }

    public String getMembershipPoint() {
        return membershipPoint;
    }

    public void setMembershipPoint(String membershipPoint) {
        this.membershipPoint = membershipPoint;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

}
