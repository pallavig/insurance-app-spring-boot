package com.thoughtworks.insuranceappspringboot.service;

import com.thoughtworks.insuranceappspringboot.exception.CustomerNotFoundException;
import com.thoughtworks.insuranceappspringboot.model.Customer;
import com.thoughtworks.insuranceappspringboot.repository.CustomerRepository;
import com.thoughtworks.insuranceappspringboot.request.CustomerDto;
import com.thoughtworks.insuranceappspringboot.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //marker annotations
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse save(CustomerDto customerDto) {
        Customer savedCustomer = customerRepository.save(new Customer(customerDto.getCustomerName()));
        return new CustomerResponse(savedCustomer.getId(), savedCustomer.getName());
//        policyService.getPolicies(customerId)
    }

    public CustomerResponse getCustomerById(Integer id) {
        Customer savedCustomer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException());
        return new CustomerResponse(savedCustomer.getId(), savedCustomer.getName());
    }

    // business

    // request(from controller) -> repo.save (customer object) -> return savedEntity

    // customer, requestClass (recommended)
}

// unit tests (faster to run), integration test

// pyramid
//  unit
// integration
// e2e/functionals

//--
// packaging techniques -
// layers
// feature (used)
// onion

// HTTP methods

// REST (resource)
// GET -> getting a customer (resource)
// POST -> creating customer
// PUT -> update, 1 -> update name
// DELETE -> delete resource


// standards:
// hotel menu
// create a menu - POST (create a new resource)
// users ask for menu - GET (retrieve the resource)
// change the price of paneer - PUT (one of the field is updated)
// no more serving paneer - DELETE

// response code standards:
// 200 -> ok
// 201 -> created
// 404 -> not found
// 401 -> permission
// 400 -> bad request




