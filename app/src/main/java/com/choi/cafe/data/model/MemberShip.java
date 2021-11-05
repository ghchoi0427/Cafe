package com.choi.cafe.data.model;

public class MemberShip {

    private String membershipID;
    private int membershipPoint;
    private Customer owner;

    public String getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }

    public int getMembershipPoint() {
        return membershipPoint;
    }

    public void setMembershipPoint(int membershipPoint) {
        this.membershipPoint = membershipPoint;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

}
