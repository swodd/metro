package com.metro.rest.controller;

import com.metro.rest.entity.Customer;
import com.metro.rest.parser.MyCsvParser;
import com.metro.rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    MyCsvParser parser = new MyCsvParser();

    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        parser.write(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("\"file_name\":\"" + parser.getDateToStr() + "\"");
    }

    @GetMapping("/customer/{mobileNo}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long mobileNo){
        Customer customer = customerRepository.findByMobileNo(mobileNo);

        /*You need to choose which one to use, from db or from file*/
        //return new ResponseEntity<>(parser.read(mobileNo), HttpStatus.CREATED);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
