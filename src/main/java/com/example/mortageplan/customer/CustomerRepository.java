package com.example.mortageplan.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Naming convetion is that any Class/interface that accesses
// the database has the name Respository
@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    // Select * from customer where name = ?
    @Query("Select c from Customer c where c.name = ?1")
    Optional<Customer> findCustomerByName(String name);
}
