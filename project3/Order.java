package com.company.project3;

import java.io.Serializable;
import java.util.Arrays;

public class Order implements Serializable {
    private Item[] item = new Item[30];
    private Customer c;
    private int totalBill;

    public Order(Customer c) {
        this.c = c;
    }

    public void addItem(Item i) {
        for (int j = 0; j < item.length; j++) {
            if (item[j]==null) {
                item[j] = i;
            }
        }
    }

    public int getBill() {
        for (int i = 0; i < item.length; i++) {
            totalBill += item[i].getPrice();
        }
        return totalBill;
    }


    public void setItem(Item[] item) {
        this.item = item;
    }


    public String toString() {
        if (c==null) {
            return "Guest: "+"   Total Bill: "+totalBill;
        }
        else
            return "Customer ID "+c.getCustID()+"   Total Bill: "+totalBill;
    }

    public String dis() {
        return "\nItem: "+ Arrays.toString(item);
    }
}
