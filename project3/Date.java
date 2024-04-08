package com.company.project3;

public class Date {
    private int day, month, year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date(int day, int month, int year) {
        if (day > 0 && day <=31) {
            this.day = day;
        }
        if (month > 0 && month <=12) {
            this.month = month;
        }
        this.year = year;
    }

    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public String display() {
        return ""+day+" / "+month+" / "+year;
    }
}
