package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Model.Customer;
import com.example.Service.CustomerService;

@RestController
public class CustomerController {
    @Autowired(required = true)
    private CustomerService customerservice;

    @PostMapping("/customervalid")
    public ResponseEntity<Customer> addValidCustomer(@Valid @RequestBody Customer c) {
        return new ResponseEntity<Customer>(customerservice.saveCustomer(c), HttpStatus.CREATED);
    }

    @GetMapping("/customer/{id}")
    public Customer findByCustomerId(@PathVariable int id) {
        return customerservice.findById(id);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return customerservice.getAllCustomers();

    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerservice.deleteCustomer(id);
        return "Customer is Deleted";
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerservice.updateCustomer(customer);
    }

    @GetMapping("/customer/Name/{name}")
    public List<Customer> findByname(@PathVariable String name) {
        return customerservice.findByName(name);
    }

    @GetMapping("/customer/Email/{email}")
    public List<Customer> findByEmail(@PathVariable String email) {
        return customerservice.findByEmail(email);
    }
}
