package com.arsatapathy.springboot.rest.client.demo.controller;

import com.arsatapathy.springboot.rest.client.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("GET_CUSTOMERS")
    private String getCustomer;

    @Autowired
    @Qualifier("GET_CUSTOMER_BY_ID")
    private String getCustomerById;

    @Autowired
    @Qualifier("ADD_CUSTOMER")
    private String addCustomer;

    @Autowired
    @Qualifier("DELETE_CUSTOMER_BY_ID")
    private String deleteCustomerById;

    @Autowired
    @Qualifier("UPDATE_CUSTOMER")
    private String updateCustomer;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Customer[]> getCustomers() {
        return restTemplate.getForEntity(getCustomer, Customer[].class);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@RequestParam(value = "id") long id) {
        return restTemplate.getForEntity(getCustomerById + id, Customer.class);
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(restTemplate.postForObject(addCustomer, customer, Customer.class), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/customer/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomer(@RequestParam(value = "id") long id) {
        restTemplate.delete(deleteCustomerById + id);
        return new ResponseEntity<>("Customer deleted!", HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        restTemplate.put(updateCustomer, customer);
        return new ResponseEntity<>("Customer updated!", HttpStatus.OK);
    }

}
