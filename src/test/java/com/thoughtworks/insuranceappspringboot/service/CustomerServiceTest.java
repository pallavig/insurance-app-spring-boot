package com.thoughtworks.insuranceappspringboot.service;

import com.thoughtworks.insuranceappspringboot.model.Customer;
import com.thoughtworks.insuranceappspringboot.repository.CustomerRepository;
import com.thoughtworks.insuranceappspringboot.request.CustomerDto;
import com.thoughtworks.insuranceappspringboot.response.CustomerResponse;
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
        CustomerResponse response = new CustomerResponse(1, "customer-name");
        Customer customerWithId = new Customer(1, "customer-name");
        Customer customer = new Customer("customer-name");
        Mockito.when(customerRepository.save(any())).thenReturn(customerWithId);

        // act
        CustomerResponse result = customerService.save(new CustomerDto("customer-name"));

        // assert
        assertEquals(response.getName(), result.getName());
        verify(customerRepository).save(customer);
    }

    @Test
    public void shouldGetCustomerById() {
        CustomerResponse expected = new CustomerResponse(1, "customer-name");
        Customer customer = new Customer(1, "customer-name");
        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        CustomerResponse actual = customerService.getCustomerById(1);

        assertEquals(expected, actual);
    }
}