package com.thoughtworks.insuranceappspringboot.repository;

import com.thoughtworks.insuranceappspringboot.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        Customer customer = new Customer("customer-name");
        customerRepository.save(customer);
    }

    @Test
    public void shouldSaveCustomer() {
        assertEquals(0, customerRepository.findAll().size());

        assertEquals(1, customerRepository.findAll().size());
    }

    @Test
    public void shouldFetchCustomerById() {
    }
}