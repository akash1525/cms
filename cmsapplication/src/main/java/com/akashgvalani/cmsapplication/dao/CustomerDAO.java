package com.akashgvalani.cmsapplication.dao;

import com.akashgvalani.cmsapplication.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {


    @Override
    List <Customer> findAll();
}
