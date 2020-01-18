package com.lti.model;

public class Student {
	private int rollNumber;
	private String studentName;
	private double studentScore;
	private Address address;// =new Address();
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

	/*
	 * public Address getAddress2() { return address2; }
	 * 
	 * public void setAddress2(Address address2) { this.address2 = address2; }
	 */

}
