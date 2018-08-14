package com.metro.rest.controller;

import com.metro.rest.entity.Customer;
import com.metro.rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping("/customer/{mobileNo}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long mobileNo){
        System.out.println(customerRepository.findByMobileNo(mobileNo));
            Customer customer = customerRepository.findByMobileNo(mobileNo);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
