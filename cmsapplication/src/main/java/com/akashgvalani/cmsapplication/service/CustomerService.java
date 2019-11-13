package com.akashgvalani.cmsapplication.service;

import com.akashgvalani.cmsapplication.dao.CustomerDAO;
import com.akashgvalani.cmsapplication.exception.CustomerNotFoundException;
import com.akashgvalani.cmsapplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

// Handling all customer details

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerCount = 1;
    private List <Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {

        return customerDAO.save(customer);

    }

    public List<Customer> getCustomers() {
      return  customerDAO.findAll();

//        return customerList;
    }

    /*get a specific customer*/
    public Customer getCustomers (int customerID) {

        Optional <Customer> optionalCustomer = customerDAO.findById(customerID);
        if(!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer Record is not available");
        }

        return customerDAO.findById(customerID).get();
    }

    public Customer updateCustomer(int customerID, Customer customer) {
        customer.setCustomerID(customerID);
        // Save works for both update and creating a new record. If no id is passed, it assumes as a new record.
       return customerDAO.save(customer);
    }

    public void deleteCustomer (int customerID) {
        customerDAO.deleteById(customerID);
    }
}
//
//        customer.setCustomerID(customerCount);
//        customerList.add(customer);
//        customerCount++;
//        return customer;

//        customerList
//                .stream().filter(c -> c.getCustomerID() == customerID).forEach(c -> {
//            c.setFirstName(customer.getFirstName());
//            c.setFirstName(customer.getLastName());
//            c.setEmail(customer.getEmail());
//        });
//
//       return customerList
//               .stream()
//               .filter(c -> c.getCustomerID() == customerID)
//               .findFirst()
//               .get();


//       return customerList.stream()
//               .filter(c -> c.getCustomerID() == customerID)
//                .findFirst()
//                .get();

//        customerList
//                .stream()
//                .forEach(c -> {
//                    if(c.getCustomerID() == customerID ) {
//                        customerList.remove(c);
//                    }
//                });