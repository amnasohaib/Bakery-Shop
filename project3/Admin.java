package com.company.project3;
import java.io.Serializable;
import java.time.Year;

public class Admin extends Person implements Serializable {
    private String adminID;
    private int salary;
    private Date hiredate;

    public Admin(String name, String email, String gender, int age, Address add, String adminID, int salary, Date hiredate) {
        super(name, email, gender, age, add);
        this.adminID = adminID;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public double earning() {
        if ((Year.now().getValue()) - hiredate.getYear() >= 5) {
            return salary * (5) / 100;
        }
        else
            return salary;
    }

    public String toString() {
        return super.toString()+" Admin ID: "+adminID+" Salary: "+salary+ " Hire Date: "+hiredate.getDay()+"/"+
                hiredate.getMonth()+"/"+hiredate.getYear();
    }
}
