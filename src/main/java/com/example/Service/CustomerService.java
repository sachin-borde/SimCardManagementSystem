package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.Model.Customer;

@Service
public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer findById(int id);

    List<Customer> getAllCustomers();

    void deleteCustomer(int id);

    Customer updateCustomer(Customer customer);

    List<Customer> findByName(String name);

    List<Customer> findByEmail(String email);

}
