package com.example.demo.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.demo.exception.DuplicateDataException;
import com.example.demo.exception.GenericException;
import com.example.demo.pojos.Customer;
import com.example.demo.util.Util;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
	@InjectMocks
	CustomerServiceImpl customerService;
	@Mock
	Util util;

	private Customer customer;
	private Customer customer1;
	List<Customer> customersData;

	@BeforeEach
	public void setUp() {
		customersData = new ArrayList<>();
		customer1 = new Customer("Narendra", "Kalavakuri", "7799", "SA7", null);
		customer = new Customer("Narendra", "Kalavakuri", "779921", "SA8", null);
		customersData.add(customer1);
		customersData.add(customer);
	}

	@AfterEach
	public void tearDown() {
		customer = customer1 = null;
		customersData = null;
	}

	@Test
	public void saveCustomerTest() {
		when(util.isSANumberExist(anyString())).thenReturn(true);
		when(util.validatingIdNumber(any(), any())).thenReturn(false);
		when(util.validatingMobileNumber(any(), any())).thenReturn(false);
		Customer customer1 = customerService.saveCustomer(customer);
		assertEquals(customer.getIDNumber(), customer1.getIDNumber());
	}

	@Test
	public void iDNumberExceptionTest() {
		when(util.isSANumberExist(anyString())).thenReturn(false);
		assertThrows(GenericException.class, () -> customerService.saveCustomer(customer),
				"ID number is not available in the records");
	}

	@Test
	public void mobileNumberExceptionTest() {
		when(util.isSANumberExist(anyString())).thenReturn(true);
		when(util.validatingMobileNumber(any(), any())).thenReturn(true);
		assertThrows(DuplicateDataException.class, () -> customerService.saveCustomer(customer),
				"Mobile Number is Duplicated and It should be unique");
	}

	@Test
	public void UpdateCustomerTest() {
		Customer customer2 = new Customer("Narendra Chowdary", "Kalavakuri", "779921", "SA8", null);
		when(util.isSANumberExist(anyString())).thenReturn(true);
		when(util.validatingIdNumber(any(), any())).thenReturn(false);
		when(util.validatingMobileNumber(any(), any())).thenReturn(false);
		customerService.saveCustomer(customer);
		Customer customer3 = customerService.UpdateCustomer(customer2);
		assertEquals(customer.getIDNumber(), customer3.getIDNumber());
	}

	@Test
	public void UpdateCustomerExceptionTest() {
		Customer customer2 = new Customer("Narendra Chowdary", "Kalavakuri", "7799", "SA7", null);
		when(util.isSANumberExist(anyString())).thenReturn(true);
		when(util.validatingIdNumber(any(), any())).thenReturn(false);
		when(util.validatingMobileNumber(any(), any())).thenReturn(false);
		customerService.saveCustomer(customer);
		when(util.isSANumberExist(anyString())).thenReturn(false);
		assertThrows(GenericException.class, () -> customerService.UpdateCustomer(customer2),
				"ID number and Mobile data matched recods are not available");

	}

	@Test
	public void fetchByIdTest() {
		assertThrows(GenericException.class, () -> customerService.fetchById("SA8"),
				"Unable to Identofy the Any customer");

	}

	@Test
	public void fetchByIdTest1() {
		List<Customer> filteredIds = customersData.stream().filter(x -> x.getIDNumber().equals("SA7"))
				.collect(Collectors.toList());
		assertEquals(1, filteredIds.size());

	}

	@Test
	public void fetchByMobileNumberTest() {
		assertThrows(GenericException.class, () -> customerService.fetchById("779921"),
				"Unable to Identofy the Any customer");

	}

	@Test
	public void fetchByMobileNumberTest1() {
		List<Customer> filteredIds = customersData.stream().filter(x -> x.getMobileNumber().equals("7799"))
				.collect(Collectors.toList());
		assertEquals(1, filteredIds.size());

	}

	public void fetchByNameTest() {
		List<Customer> filteredIds = customersData.stream().filter(x -> x.getFirstName().equals("Narendra"))
				.collect(Collectors.toList());
		assertEquals(1, filteredIds.size());

	}

}
