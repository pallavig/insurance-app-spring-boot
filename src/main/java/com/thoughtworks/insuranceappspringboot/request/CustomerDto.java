package com.thoughtworks.insuranceappspringboot.request;

public class CustomerDto {
    private String customerName;

    public CustomerDto(String customerName) {
        this.customerName = customerName;
    }

    public CustomerDto() {
    }

    public String getCustomerName() {
        return customerName;
    }
}
