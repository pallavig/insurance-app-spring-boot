package com.thoughtworks.insuranceappspringboot.repository;

import com.thoughtworks.insuranceappspringboot.model.Customer;
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

    @Test
    public void shouldSaveCustomer() {
        Customer customer = new Customer("customer-name");
        System.out.println("customer before saving");
        System.out.println(customer);

        assertEquals(0, customerRepository.findAll().size());
        Customer savedCustoemr = customerRepository.save(customer);
        System.out.println("Customer after saving");
        System.out.println(savedCustoemr);

        assertEquals(1, customerRepository.findAll().size());
    }
}