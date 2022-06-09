package com.example.mortageplan.customer;

import javax.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private long iD;
    private String name;
    private double loan;
    private double interest;
    private Integer years;

    private double monthPayment;

    public Customer() {
    }

    public Customer(long iD,
                    String name,
                    double loan,
                    double interest,
                    Integer years, double monthPayment) {

        this.iD = iD;
        this.name = name;
        this.loan = loan;
        this.interest = interest;
        this.years = years;
        this.monthPayment = monthPayment;
    }

    public Customer(String name,
                    double loan,
                    double interest,
                    Integer years, double monthPayment) {

        this.name = name;
        this.loan = loan;
        this.interest = interest;
        this.years = years;
        this.monthPayment = monthPayment;
    }

    public double getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(double monthPayment) {
        this.monthPayment = monthPayment;
    }

    public long getiD() {
        return iD;
    }

    public void setiD(long iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", loan=" + loan +
                ", interest=" + interest +
                ", years=" + years +
                '}';
    }
}

