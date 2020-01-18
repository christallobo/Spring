package com.lti.service;

import com.lti.dao.StudentDao;
import com.lti.model.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao;

	@Override
	public boolean addStudent(Student student) {
		int result = dao.createStudent(student);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public Student findStudentByRollNumber(int rollNumber) {
		Student result= dao.readStuentByRollNumber(rollNumber);
		return result;
	}

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

}
