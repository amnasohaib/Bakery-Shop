package com.company.project3;

import java.io.Serializable;

public class Person implements Serializable {
    private String name, email, gender;
    private int age;
    private Address add;

    public Person(String name, String email, String gender, int age, Address add) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public String toString() {
        return "Name: "+name+" Age: "+age+" Email: "+email+" Gender: "+gender+" Address: "+add.toString();
    }
}
