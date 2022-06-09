package com.example.mortageplan.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;

@Configuration
public class CustomerConfig {

    FileHandler fileHandler = new FileHandler();
    List<Customer> customerList = fileHandler.readFile();

    //Used to run a background task to push the customers from the file to the database
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository) {
        return args -> {
            repository.saveAll(customerList);
        };
    }
}
