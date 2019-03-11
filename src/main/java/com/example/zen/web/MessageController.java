package com.example.zen.web;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.zen.entity.Customer;
import com.example.zen.repository.CustomerRepository;
import com.example.zen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    CustomerService service;

    @GetMapping()
    public Customer findById(@RequestBody final Long id)
            throws UnsupportedEncodingException{

        Optional<Customer> customerOptional = service.findById(id);

        if(customerOptional.isPresent()){
            return customerOptional.get();
        }

        return null;
    }

    @PostMapping()
    public ResponseEntity<String> save()
            throws UnsupportedEncodingException{

        service.createCustomers();

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
