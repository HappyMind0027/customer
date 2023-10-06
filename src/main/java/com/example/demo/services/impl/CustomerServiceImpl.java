package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DuplicateDataException;
import com.example.demo.exception.GenericException;
import com.example.demo.pojos.Customer;
import com.example.demo.services.CustomerService;
import com.example.demo.util.Util;

import jakarta.validation.Valid;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private Util util;
	private List<Customer> Customers = new ArrayList<Customer>();

	/*
	 * Below method will help to fetch all customer Info
	 * 
	 * @Return List of the Customer info
	 * 
	 */

	public List<Customer> getCustomerData() {
		// TODO Auto-generated method stub
		return Customers;
	}

	/*
	 * Below Method will help to Save the Customer info
	 * 
	 * @Param Customer
	 * 
	 * @return saved customer Info
	 * 
	 */
	@Override
	public Customer saveCustomer(Customer customer) {

		if (util.isSANumberExist(customer.getIDNumber()) == false) {
			throw new GenericException("ID number is not available in the records");
		}

		if (util.validatingMobileNumber(customer, Customers)) {
			throw new DuplicateDataException("Mobile Number is Duplicated and It should be unique");
		} else if (util.validatingIdNumber(customer, Customers)) {
			throw new DuplicateDataException("ID Number is Duplicated and It should be unique");
		} else {
			Customers.add(customer);
		}
		return customer;
	}

	/*
	 * Below method will help to update the customer Info based on the Id Number and
	 * Mobile Number combination
	 * 
	 * @Param Customer
	 * 
	 * @return Updated customer info
	 * 
	 */
	@Override
	public Customer UpdateCustomer(@Valid Customer customer) {
		if (util.isSANumberExist(customer.getIDNumber()) == false) {
			throw new GenericException("ID number is not available in the records");
		}
		boolean isIdAndNumberAvailable = false;

		int counter = 0;
		for (Customer customerData : Customers) {
			if (customerData.getIDNumber().equals(customer.getIDNumber())
					&& customerData.getMobileNumber().equals(customer.getMobileNumber())) {
				Customers.set(counter, customer);
				isIdAndNumberAvailable = true;
			}
			counter++;
		}
		if (isIdAndNumberAvailable == false) {
			throw new GenericException("ID number and Mobile data matched recods are not available");
		}

		return customer;
	}

	@Override
	public Optional<Customer> fetchById(String id) {
		Optional<Customer> customer = null;
		customer = Customers.stream().filter(x -> x.getIDNumber().equals(id)).findFirst();
		if (!customer.isPresent()) {
			throw new GenericException("Unable to Identofy the Any customer");
		}

		return customer;
	}

	@Override
	public Optional<Customer> fetchByMobileNumber(String number) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = null;
		customer = Customers.stream().filter(x -> x.getMobileNumber().equals(number)).findFirst();
		if (!customer.isPresent()) {
			throw new GenericException("Unable to Identofy the Any customer");
		}
		return customer;
	}

	@Override
	public List<Customer> fetchByFirstName(String name) {
		return Customers.stream().filter(x -> x.getFirstName().equals(name)).collect(Collectors.toList());
	}

}
