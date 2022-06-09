package com.example.mortageplan.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Contains the business logic for the application
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CalculateMortgage calculateMortgage;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CalculateMortgage calculateMortgage) {
        this.customerRepository = customerRepository;
        this.calculateMortgage = calculateMortgage;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void setCustomerPayment(Customer customer) {
        if (customer != null && customer.getName() != "" && customer.getLoan() != 0 && customer.getInterest() != 0
        && customer.getYears() != 0) {
            customer.setMonthPayment(calculateMortgage.mortgageCalculation(customer.getLoan(), customer.getInterest(),
                            customer.getYears()));
        }
    }
}

