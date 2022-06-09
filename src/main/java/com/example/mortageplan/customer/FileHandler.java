package com.example.mortageplan.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileHandler {

    private CustomerRepository customerRepository;
    private CalculateMortgage calculateMortgage;

    @Autowired
    public void FileHandler(CustomerRepository repository) {
      this.customerRepository = repository;
    }

    public List<Customer> readFile() {
        calculateMortgage = new CalculateMortgage();
        List<List<String>> customers = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("SET PATH TO FILE HERE"))) {
            //String line;
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("\"")) {
                    line = line.replaceFirst("(?:,)+", " ");
                }
                if (line.contains("\"")) {
                    line = line.replace("\"", "");
                }

                String[] values = line.split(",");
                customers.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (List<String> arr: customers) {

            Customer customer = new Customer();
            customer.setName(arr.get(0));
            customer.setLoan(Double.parseDouble((arr.get(1))));
            customer.setInterest(Double.parseDouble(arr.get(2)));
            customer.setYears(Integer.valueOf(arr.get(3)));
            customer.setMonthPayment(calculateMortgage.mortgageCalculation(customer.getLoan(), customer.getInterest(),
                    customer.getYears()));

            customerList.add(customer);
        }
        return customerList;
    }

}
