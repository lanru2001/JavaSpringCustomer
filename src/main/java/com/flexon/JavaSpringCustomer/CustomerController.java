package com.flexon.JavaSpringCustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO = new CustomerDAO();

    //Get all customers from arraylist
    @GetMapping(path = "/getAllCustomer")
    public ArrayList<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    //Get specific customer from arraylist
    @GetMapping(path = "/getCustomerById/{id}")
    public ArrayList<Customer> getCustomerById(@PathVariable String id) {
        return customerDAO.getCustomerById(id);
    }

    @DeleteMapping(value = "/deleteCustomerById/{id}")
    public Customer deleteCustomerById(@PathVariable String id) {
//        return new ResponseEntity<>("Delete customer", HttpStatus.OK);
        return customerDAO.deleteCustomerById(id);
    }

    //Adding a new customer into the customer list
    @PostMapping(path="/addNewCustomer")
    public ResponseEntity addNewCustomer(@RequestBody Customer newCustomer){
        customerDAO.addNewCustomer(newCustomer);
        return new ResponseEntity<>("Created new customer", HttpStatus.CREATED);
    }
}
