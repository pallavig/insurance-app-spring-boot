package com.thoughtworks.insuranceappspringboot.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerResponseTest {

    @Test
    public void shouldSerialize() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(new CustomerResponse(1, "thoughtworks"));
        System.out.println(jsonString);
    }
}