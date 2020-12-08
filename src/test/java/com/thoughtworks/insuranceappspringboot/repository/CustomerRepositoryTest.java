package com.thoughtworks.insuranceappspringboot.repository;

import com.thoughtworks.insuranceappspringboot.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldSaveCustomer() {
        Customer customer = new Customer("customer-name");
        customerRepository.save(customer);
        assertEquals(1, customerRepository.findAll().size());
    }

    @Test
    public void shouldFetchCustomerById() {
        Customer customer = new Customer("customer-name");
        Customer savedCustomer = customerRepository.save(customer);
        Optional<Customer> customerO = customerRepository.findById(savedCustomer.getId());
        System.out.println(customerO.get());
    }
    // database always increment the number, id -
    // beforeAll, this is in junit 5
    // h2 database configuration, when is it being cleared [REVISIT]
}