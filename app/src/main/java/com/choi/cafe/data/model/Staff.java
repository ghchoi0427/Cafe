package com.choi.cafe.data.model;

public class Staff {

    private String staffNumber;
    private String name;
    private String sex;
    private String age;
    private String position;

    public Staff(String staffNumber, String name, String sex, String age, String position) {
        this.staffNumber = staffNumber;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.position = position;
    }

    public Staff() {
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
