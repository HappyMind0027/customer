package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.pojos.Customer;
import com.example.demo.services.CustomerService;

import jakarta.validation.Valid;

@Validated
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer")
	public List<Customer> getCustomer() {
		return customerService.getCustomerData();
	}

	@PostMapping(value = "/customer", consumes = { "application/json" })
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@PutMapping("/customer")
	public Customer getCustomer(@Valid @RequestBody Customer customer) {
		return customerService.UpdateCustomer(customer);
	}

	@PostMapping(value = "/customer/ID/{ID}")
	public Optional<Customer> fectchCustomerBtId(@PathVariable String ID) {
		return customerService.fetchById(ID);
	}

	@PostMapping(value = "/customer/mobileNumber/{number}")
	public Optional<Customer> fectchCustomerByMobileNumber(@PathVariable String number) {
		return customerService.fetchByMobileNumber(number);
	}

	@PostMapping(value = "/customer/firstName/{name}")
	public List<Customer> fectchCustomerByFirstName(@PathVariable String name) {
		return customerService.fetchByFirstName(name);
	}

}
