package com.company.project3;

import java.io.Serializable;

public class Sweet extends Item implements Serializable {
    private String flavour;

    public Sweet(String id, String name, double price, int quantity, String flavour) {
        super(id, name, price, quantity);
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String toString() {
        return super.toString()+"   Flavour: "+flavour;
    }
}
