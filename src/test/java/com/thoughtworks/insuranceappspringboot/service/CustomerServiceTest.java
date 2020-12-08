package com.thoughtworks.insuranceappspringboot.service;

import com.thoughtworks.insuranceappspringboot.model.Customer;
import com.thoughtworks.insuranceappspringboot.repository.CustomerRepository;
import com.thoughtworks.insuranceappspringboot.request.CustomerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock //fake
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @Before
    public void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    public void shouldCreateCustomer() {
        // prepare
        Customer expected = new Customer("customer-name");
        Mockito.when(customerRepository.save(any())).thenReturn(expected);

        // act
        Customer result = customerService.save(new CustomerDto("customer-name"));

        // assert
        assertEquals(expected.getName(), result.getName());
        verify(customerRepository).save(expected);
    }

    @Test
    public void shouldGetCustomerById() {
        Customer expected = new Customer("customer-name");
        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(expected));

        Customer actual = customerService.getCustomerById(1);

        assertEquals(expected, actual);
    }
}