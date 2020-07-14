package com.flexon.JavaSpringCustomer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class CustomerDAO {
    private ArrayList<Customer> customersList = new ArrayList<>();
    private HashMap<String, Customer> idToCustomer = new HashMap<>();

    public CustomerDAO(){
        Customer deep = new Customer("1","deep", "Singh", "1234");
        Customer Tom = new Customer("2","Tom", "Cat", "12345");
        Customer Spring = new Customer("3","Spring", "Boot", "321");
        customersList.add(deep);
        customersList.add(Tom);
        customersList.add(Spring);
        idToCustomer.put("1", deep);
        idToCustomer.put("2", Tom);
        idToCustomer.put("3", Spring);
    }

    public ArrayList<Customer> getAllCustomers(){
        return customersList;
    }

    public ArrayList<Customer> getCustomerById(String id){
        ArrayList<Customer> temp = new ArrayList<>();
        temp.add(idToCustomer.get(id));
        return temp;
    }

    public Customer deleteCustomerById(String id){
        Customer c = idToCustomer.remove(id);
        customersList.remove(c);
        return c;
    }

    public Customer addNewCustomer(Customer newCustomer) {
        customersList.add(newCustomer);
        idToCustomer.put(newCustomer.getCustomerid(), newCustomer);
        return newCustomer;

    }

}
