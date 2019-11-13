package com.akashgvalani.cmsapplication.api;

import com.akashgvalani.cmsapplication.model.Customer;
import com.akashgvalani.cmsapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerID}")
    public Customer getCustomers(@PathVariable("customerID") int customerID) {
        return customerService.getCustomers(customerID);
    }

    @PutMapping("/{customerID}")
    public Customer updateCustomer(@PathVariable  int customerID, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerID, customer);
    }

    @DeleteMapping("/{customerID}")
    public void deleteCustomer(@PathVariable  int customerID, @RequestBody Customer customer) {
        customerService.deleteCustomer(customerID);
    }
}

