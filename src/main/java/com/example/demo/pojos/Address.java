package com.example.demo.pojos;

public class Address {
	private String address;
	private String lineNumber;
	private String StreetName;
	private String city;
	private String State;
	private String pincode;
	private String nation;

	public Address() {
		super();
	}

	public Address(String address, String lineNumber, String streetName, String city, String state, String pincode,
			String nation) {
		super();
		this.address = address;
		this.lineNumber = lineNumber;
		StreetName = streetName;
		this.city = city;
		State = state;
		this.pincode = pincode;
		this.nation = nation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

}
