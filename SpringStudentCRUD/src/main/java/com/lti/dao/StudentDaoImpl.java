package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import com.lti.model.Student;

public class StudentDaoImpl implements StudentDao {
	private static List<Student> students;

	public StudentDaoImpl() {
		students = new ArrayList<>();
	}

	@Override
	public int createStudent(Student student) {
		boolean result = students.add(student);
		if (result)
			return 1;
		else
			return 0;
	}

	@Override
	public Student readStuentByRollNumber(int rollNumber) {
		for(Student s:students){
			if(s.getRollNumber()==rollNumber){
				return s;
			}
		}
		return null;
	}

}
