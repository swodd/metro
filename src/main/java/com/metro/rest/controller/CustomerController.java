package com.metro.rest.controller;

import com.metro.rest.entity.Customer;
import com.metro.rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/customer/{mobileNo}")
    public Customer getCustomerById(@PathVariable Long mobileNo){
        System.out.println(customerRepository.findByMobileNo(mobileNo));
            return customerRepository.findByMobileNo(mobileNo);
    }
}
