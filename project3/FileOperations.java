package com.company.project3;

import java.io.*;
import java.util.ArrayList;

public class FileOperations {
    public static void addACustomer(Customer s) {
        try {
            File f = new File("customer.txt");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
        }
        catch (IOException e) {
            System.out.println("error in file writing");
        }
    }

    public static ArrayList<Customer> readAllFromCustomerFile() {
        ArrayList<Customer> clist= new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customer.txt"));
            while (true) {
                Customer s = (Customer) ois.readObject();
                clist.add(s);
            }
        }
        catch (ClassNotFoundException z) {}
        catch (EOFException e ) {}
        catch (IOException c) {}
        return clist;
    }

    public static void addSavoury(Savoury s) {
        try {
            File f = new File("savoury.txt");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
        }
        catch (IOException e) {
            System.out.println("error in file writing");
        }
    }

    public static void addSweet(Sweet s) {
        try {
            File f = new File("sweet.txt");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
        }
        catch (IOException e) {
            System.out.println("error in file writing");
        }
    }

    public static void addOrder(Order o) {
        try {
            File f = new File("order.txt");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(o);
            oos.close();
        }
        catch (IOException e) {
            System.out.println("error in file writing");
        }
    }

    public static ArrayList<Savoury> readAllFromSavoury() {
        ArrayList<Savoury> ilist = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savoury.txt"));
            while (true) {
                Savoury s = (Savoury) ois.readObject();
                ilist.add(s);
            }
        }
        catch (ClassNotFoundException z) {}
        catch (EOFException e ) {}
        catch (IOException c) {}
        return ilist;
    }

    public static ArrayList<Sweet> readAllFromSweet() {
        ArrayList<Sweet> ilist = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sweet.txt"));
            while (true) {
                Sweet s = (Sweet) ois.readObject();
                ilist.add(s);
            }
        }
        catch (ClassNotFoundException z) {}
        catch (EOFException e ) {}
        catch (IOException c) {}
        return ilist;
    }

    public static ArrayList<Order> readAllFromOrdersFile() {
        ArrayList<Order> olist = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("order.txt"));
            while (true) {
                Order s = (Order) ois.readObject();
                olist.add(s);
            }
        }
        catch (ClassNotFoundException z) {}
        catch (EOFException e ) {}
        catch (IOException c) {}
        return olist;
    }

    public static Sweet deleteSweet(String name) {
        ArrayList<Sweet> alist = readAllFromSweet();
        Sweet item = null;
        for (int i = 0; i< alist.size(); i++) {
            if (alist.get(i).getName().equals(name) || alist.get(i).getId().equalsIgnoreCase(name)) {
                if (alist.get(i).getQuantity() > 1) {
                    alist.get(i).setQuantity((alist.get(i).getQuantity())-1);
                    item = alist.get(i);
                }
                else {
                    item = alist.get(i);
                    alist.remove(i);
                    break;
                }
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("sweet.txt")));
            for (int i = 0; i< alist.size(); i++) {
                oos.writeObject(alist.get(i));
            }
            return item;
        }
        catch (IOException e) {}
        return item;
    }

    public static Savoury deleteSavoury(String name) {
        ArrayList<Savoury> alist = readAllFromSavoury();
        Savoury item = null;
        for (int i = 0; i< alist.size(); i++) {
            if (alist.get(i).getName().equals(name) || alist.get(i).getId().equalsIgnoreCase(name)) {
                if (alist.get(i).getQuantity() > 1) {
                    alist.get(i).setQuantity((alist.get(i).getQuantity())-1);
                    item = alist.get(i);
                }
                else {
                    item = alist.get(i);
                    alist.remove(i);
                    break;
                }
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("savoury.txt")));
            for (int i = 0; i< alist.size(); i++) {
                oos.writeObject(alist.get(i));
            }
            return item;
        }
        catch (IOException e) {}
        return item;
    }

    public static Customer searchACustomer(String username, String pass) {
        ArrayList<Customer> clist = readAllFromCustomerFile();

        for (int i = 0; i< clist.size(); i++) {
            if (clist.get(i).getCustID().equalsIgnoreCase(username) && clist.get(i).getPass().equals(pass)) {
                return clist.get(i);
            }
        }
        return null;
    }

    public static Sweet searchSweet(String name) {
        ArrayList<Sweet> clist = readAllFromSweet();

        for (int i = 0; i< clist.size(); i++) {
            if (clist.get(i).getId().equalsIgnoreCase(name) || clist.get(i).getName().equalsIgnoreCase(name)) {
                Sweet j = (clist.get(i));
                return j;
            }
        }
        return null;
    }

    public static Savoury searchSavoury(String name) {
        ArrayList<Savoury> clist = readAllFromSavoury();

        for (int i = 0; i< clist.size(); i++) {
            if (clist.get(i).getId().equalsIgnoreCase(name) || clist.get(i).getName().equalsIgnoreCase(name)) {
                Savoury j = (clist.get(i));
                return j;
            }
        }
        return null;
    }
}
