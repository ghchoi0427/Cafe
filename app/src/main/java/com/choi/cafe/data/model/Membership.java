package com.choi.cafe.data.model;

import java.util.Map;

public class Membership {

    private String membershipID;
    private String membershipPoint;
    private Map<String, String> owner;

    public Membership() {
    }

    public Membership(String membershipID, String membershipPoint, Map<String, String> owner) {
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

    public Map<String, String> getOwner() {
        return owner;
    }

    public void setOwner(Map<String, String> owner) {
        this.owner = owner;
    }

}
