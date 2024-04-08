package com.company.project3;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private String custID;
    private String pass;

    public Customer(String name, String email, String gender, int age, Address add, String custID, String pass) {
        super(name, email, gender, age, add);
        this.custID = custID;
        this.pass = pass;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString() {
        return super.toString()+" Customer ID: "+custID;
    }
}
