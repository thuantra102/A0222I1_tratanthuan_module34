package com.example.doodling_funamental_spring_boot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Customer {
    private String name;
    private Address address;
//
//    public Customer() {
//    }


    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
