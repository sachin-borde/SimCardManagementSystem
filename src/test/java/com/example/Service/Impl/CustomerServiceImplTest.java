package com.example.Service.Impl;

import com.example.Model.Customer;
import com.example.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setAge(30);
        customer.setGender("Male");
        customer.setAddress("123 Main St");
        customer.setAdhar_no(1234567890);
        customer.setContact("555-555-5555");
        customer.setEmail("johndoe@example.com");
        customer.setSim_no(1876543210);
        customer.setStatus("Active");

        customer = customerService.saveCustomer(customer);
        assertNotNull(customer);
        assertNotNull(customer.getId());
    }

    @Test
    public void testFindById() {
        Customer customer = customerService.findById(1);
        assertNotNull(customer);
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        assertNotNull(customers);
        assertEquals(1, customers.size());
    }

    @Test
    public void testDeleteCustomer() {
        customerService.deleteCustomer(1);
        Customer customer = customerService.findById(1);
        assertNull(customer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = customerService.findById(1);
        customer.setName("Jane Doe");
        customer = customerService.updateCustomer(customer);
        assertNotNull(customer);
        assertEquals("Jane Doe", customer.getName());
    }

    @Test
    public void testFindByName() {
        List<Customer> customers = customerService.findByName("John Doe");
        assertNotNull(customers);
        assertEquals(1, customers.size());
    }

    @Test
    public void testFindByEmail() {
        List<Customer> customers = customerService.findByEmail("johndoe@example.com");
        assertNotNull(customers);
        assertEquals(1, customers.size());
    }
}
