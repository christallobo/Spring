package com.lti.dao;

import com.lti.model.Student;

public interface StudentDao {
	public int createStudent(Student student);

	public Student readStuentByRollNumber(int rollNumber);
}
