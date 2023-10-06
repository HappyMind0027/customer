package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojos.Customer;

import jakarta.validation.Valid;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getCustomerData();

	Customer UpdateCustomer(@Valid Customer customer);

	Optional<Customer> fetchById(String iD);

	Optional<Customer> fetchByMobileNumber(String number);

	List<Customer> fetchByFirstName(String name);

}
