package com.company.project3;

import java.io.Serializable;

public class Savoury extends Item implements Serializable {
    private int spiceLevel;

    public Savoury(String id, String name, double price, int quantity, int spiceLevel) {
        super(id, name, price, quantity);
        this.spiceLevel = spiceLevel;
    }

    public int getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(int spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public String toString() {
        return super.toString()+"   SpiceLevel: "+spiceLevel;
    }
}
