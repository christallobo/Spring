package com.lti.dao;

import java.util.List;

import com.lti.model.Student;

public interface StudentDao {
	public int createStudent(Student student);

	public Student readStuentByRollNumber(int rollNumber);

	public int updateStudent(Student student);

	public int deleteStudentByRollNumber(int rollNumber);
	
	public List<Student> AllStudents();

	public void beginTransaction();

	public void commitTransaction();

	public void rollBackTransaction();
}
