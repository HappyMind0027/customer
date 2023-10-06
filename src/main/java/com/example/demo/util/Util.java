package com.example.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.pojos.Customer;

@Component
public class Util {
	public Boolean isSANumberExist(String IdNumber) {
		boolean isSAIdNumberMatch = false;
		List<String> SAIdNumber = new ArrayList<>(
				Arrays.asList("SA1", "SA2", "SA3", "SA4", "SA5", "SA6", "SA7", "SA8", "SA9"));
		isSAIdNumberMatch = SAIdNumber.stream().anyMatch(x -> x.equals(IdNumber));
		System.out.println("isSAIdNumberMatch --------" + isSAIdNumberMatch);
		return isSAIdNumberMatch;
	}

	public boolean validatingMobileNumber(Customer customer, List<Customer> Customers) {

		return Customers.stream().anyMatch(x -> x.getMobileNumber().equals(customer.getMobileNumber()));

	}

	public boolean validatingIdNumber(Customer customer, List<Customer> Customers) {
		return Customers.stream().anyMatch(x -> x.getIDNumber().equals(customer.getIDNumber()));
	}

}
