package com.company.project3;

import java.io.Serializable;

public class Address implements Serializable {
    private int home, street;
    private String city;

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Address(int home, int street, String city) {
        this.home = home;
        this.street = street;
        this.city = city;
    }

    public String toString() {
        return "house: "+home+" street: "+street+" city: "+city;
    }
}
