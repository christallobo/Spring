package com.lti.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean,DisposableBean{
	private int rollNumber;
	private String studentName;
	private double studentScore;
	private Address address;// =new Address();`
	//private Address address2;

	public Student(int rollNumber, String studentName, double studentScore) {
		super();
		System.out.println("-----Student(-, -, -)-----");
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	public Student(Address address) {
		super();
		this.address = address;
	}

	public Student() {
		super();
		System.out.println("-----Student-----");
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(double studentScore) {
		this.studentScore = studentScore;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentName=" + studentName + ", studentScore=" + studentScore
				+ "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public void afterPropertiesSet() throws Exception {// called when object created.... it is called after property set
		System.out.println("Student Bean is ready to use.");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Student Bean is about to delete");
		
	}

	public void init(){
		System.out.println("Custom init method");
	}
	
	public void delete(){
		System.out.println("Custom delete method");
	}
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("@PostConstruct method");
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println("@PreDestroy method");
	}
}
