package com.example.ham.text3.model;

import java.io.Serializable;

/**
 * Created by Ham on 8/19/2017.
 */

public class Staff implements Serializable {
    private String staffId;
    private int age;
    private String name;
    private String address;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return "Trần Thanh Tuấn";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
