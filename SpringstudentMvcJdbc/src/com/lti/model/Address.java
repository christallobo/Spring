package com.lti.model;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private int addressId;
	private String city;
	private String pin;

	public Address(int addressId, String city, String pin) {
		super();
		System.out.println("-----Adress(-,-,-)-----");
		this.addressId = addressId;
		this.city = city;
		this.pin = pin;
	}

	public Address() {
		super();
		System.out.println("----Address----");
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pin=" + pin + "]";
	}

}
