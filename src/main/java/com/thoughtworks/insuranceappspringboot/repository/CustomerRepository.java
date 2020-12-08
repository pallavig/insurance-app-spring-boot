package com.thoughtworks.insuranceappspringboot.repository;

import com.thoughtworks.insuranceappspringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    jdbc
//    connection pooling, get connection, query -> result -> model
//    transaction
//    exception handling
}
// rest controller, create a customer(name) (insurance)

// repo(database), service(business logic) and rest controller (request and response)
