package com.lti.ui;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main1 {

	public static void main(String[] args) {
		Student student=new Student(1, "disha", 60);
		Address address=new Address();
		address.setAddressId(10);
		address.setCity("mumbai");
		address.setPin("445204");
		
		student.setAddress(address); //it will setup the dependency(ie.setter injection)
		
		System.out.println(student);
		System.out.println(student.getAddress());
	}

}
