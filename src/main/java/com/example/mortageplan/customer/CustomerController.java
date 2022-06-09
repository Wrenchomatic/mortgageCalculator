package com.example.mortageplan.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//The controller controls where the HTTP requests are directed and it also calls on the CustomerService to run
//certain functionality.
@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final CalculateMortgage calculateMortgage;

    @Autowired
    public CustomerController(CustomerService customerService, CalculateMortgage calculateMortgage) {
        this.customerService = customerService;
        this.calculateMortgage = calculateMortgage;
    }

    @RequestMapping(path = "/users")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "users";
    }

    @GetMapping(path = "/mortgage")
    public String MortageForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "mortgage";
    }

    @PostMapping(path = "/mortgage")
    public String MortgageSubmit(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        customerService.setCustomerPayment(customer);
        if (customer.getName() != "" && customer.getLoan() != 0 && customer.getInterest() != 0
                && customer.getYears() != 0 && customer.getMonthPayment() != 0) {
            customerService.addNewCustomer(customer);
        }
        return "mortgage";
    }

}
