package com.choi.cafe.data.model;

public class Membership {

    private String membershipID;
    private String membershipPoint;
    private String ownerID;

    public Membership() {
    }

    public Membership(String membershipID, String membershipPoint, String owner) {
        this.membershipID = membershipID;
        this.membershipPoint = membershipPoint;
        this.ownerID = owner;
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

    public String getOwner() {
        return ownerID;
    }

    public void setOwner(String owner) {
        this.ownerID = owner;
    }

}
