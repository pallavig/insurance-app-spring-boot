package com.thoughtworks.insuranceappspringboot.controller;

import com.thoughtworks.insuranceappspringboot.request.CustomerDto;
import com.thoughtworks.insuranceappspringboot.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// hit endpoint, correct data, its a success
// mocking the service
@WebMvcTest
@RunWith(SpringRunner.class)
public class CustomerControllerTest {
    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveCustomer() throws Exception {
        when(customerService.save(new CustomerDto("thoughtworks"))).thenReturn(null);

        // assert on data
        mockMvc.perform(post("/customers")
                .content("{\"customerName\": \"thoughtworks\"}")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }
}