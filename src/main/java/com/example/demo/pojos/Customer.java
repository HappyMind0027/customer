package com.example.demo.pojos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Customer {

	@NotNull(message = "FirstName required")
	@NotEmpty(message = "FirstName required")

	private String FirstName;
	@NotNull(message = "LastName required")
	@NotEmpty(message = "LastName required")
	private String LastName;
	private String MobileNumber;
	@NotNull(message = "IDNumber required")
	@NotEmpty(message = "IDNumber required")
	private String IDNumber;
	private Address address;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String mobileNumber, String iDNumber, Address address) {
		super();
		FirstName = firstName;
		LastName = lastName;
		MobileNumber = mobileNumber;
		IDNumber = iDNumber;
		this.address = address;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [FirstName=" + FirstName + ", LastName=" + LastName + ", MobileNumber=" + MobileNumber
				+ ", IDNumber=" + IDNumber + ", address=" + address + "]";
	}

}
