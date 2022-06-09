package com.example.mortageplan.customer;

import org.springframework.stereotype.Service;

@Service
public class CalculateMortgage {

    private Integer p;
    private double b;
    private double E;
    private double numerator;
    private double denominator;

    //Calculates the mortgage using the fixed mortgage formula
    public double mortgageCalculation(double total_loan, double interest, Integer years) {

        if ((years != 0 && total_loan > 0.0 && interest > 0.0)) {
            p = years * 12;
            b = (interest / 100);
            numerator = ((total_loan * b) * (powerOf((1 + b), p)));
            denominator = (powerOf((1 + b), p) - 1);

            //Is String.format allowed?
            E = Double.parseDouble(String.format("%.2f", (numerator / denominator)));

            return E;
        } else
            return 0.0;
    }

    public double powerOf(double base, double exponent) {
        double result = 1;

        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }

}
