package com.lti.service;

import java.util.List;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);

	public Student findStudentByRollNumber(int rollNumber);

	public boolean updateStudentDetails(Student student);

	public boolean deleteStudentByRollNumber(int rollnumber);

	public List<Student> AllStudent();
}
