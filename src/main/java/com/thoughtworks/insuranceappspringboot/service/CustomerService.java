package com.thoughtworks.insuranceappspringboot.service;

import com.thoughtworks.insuranceappspringboot.model.Customer;
import com.thoughtworks.insuranceappspringboot.repository.CustomerRepository;
import com.thoughtworks.insuranceappspringboot.request.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //marker annotations
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(CustomerDto customerDto) {
        return customerRepository.save(new Customer(customerDto.getCustomerName()));
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).get(); // what to do if object is not present - later
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

