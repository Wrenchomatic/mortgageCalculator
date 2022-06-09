package com.example.mortageplan;

import com.example.mortageplan.customer.CalculateMortgage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MortagePlanApplication {

    public static void main(String[] args)
    {
        //CalculateMortgage calculateMortgage = new CalculateMortgage();
        SpringApplication.run(MortagePlanApplication.class, args);
        //System.out.println("Test mortagecalculation: " + calculateMortgage.mortageCalculation(10000, 3.0, 1));
    }
}
