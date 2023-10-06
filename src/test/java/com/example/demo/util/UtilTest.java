package com.example.demo.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.pojos.Customer;

@ExtendWith(MockitoExtension.class)
public class UtilTest {
	@InjectMocks Util util;
	
	@Test
	public void isSANumberExistTest() {
		boolean flag = util.isSANumberExist("SA7");
		assertEquals(true,flag);
		
	}
	
	
	@Test
	public void isSANumberExistTest1() {
		boolean flag = util.isSANumberExist("SA");
		assertEquals(false,flag);
		
	}
	
	@Test
	public void validatingMobileNumberTest() {
		Customer customer = new Customer("Narendra", "Kalavakuri", "7799", "SA7", null);
		Customer customer1 = new Customer("Narendra", "Kalavakuri", "779921", "SA8", null);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer1);
		boolean flag = util.validatingMobileNumber(customer, customers);
		assertEquals(true,flag);
	}

	@Test
	public void validatingMobileNumberTest1() {
		Customer customer = new Customer("Narendra", "Kalavakuri", "7799", "SA7", null);
		Customer customer1 = new Customer("Narendra", "Kalavakuri", "779921", "SA8", null);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer1);
		boolean flag = util.validatingMobileNumber(new Customer("Narendra", "Kalavakuri", "779", "SA7", null), customers);
		assertEquals(false,flag);
	}
	
	@Test
	public void validatingIdNumberTest() {
		Customer customer = new Customer("Narendra", "Kalavakuri", "7799", "SA7", null);
		Customer customer1 = new Customer("Narendra", "Kalavakuri", "779921", "SA7", null);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer1);
		boolean flag = util.validatingMobileNumber(customer, customers);
		assertEquals(true,flag);
	}
	
	@Test
	public void validatingIdNumberTest1() {
		Customer customer = new Customer("Narendra", "Kalavakuri", "7799", "SA7", null);
		Customer customer1 = new Customer("Narendra", "Kalavakuri", "779921", "SA8", null);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer1);
		boolean flag = util.validatingMobileNumber(new Customer("Narendra", "Kalavakuri", "779", "SA9", null), customers);
		assertEquals(false,flag);
	}
}
