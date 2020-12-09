package com.thoughtworks.insuranceappspringboot.controller;

import com.thoughtworks.insuranceappspringboot.model.Customer;
import com.thoughtworks.insuranceappspringboot.response.CustomerResponse;
import com.thoughtworks.insuranceappspringboot.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.thoughtworks.insuranceappspringboot.request.CustomerDto;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// expose an endpoint(POST, create a customer) -> request body (CustomerDto)
// delegate service -> return Customer
@RestController
@RequestMapping("/customers") // nouns in endpoint names
class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerDto customerDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/customers")).body(customerService.save(customerDto));
    }
}