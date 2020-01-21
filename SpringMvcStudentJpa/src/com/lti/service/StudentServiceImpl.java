package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.StudentDao;
import com.lti.model.Student;

@Service("service")
public class StudentServiceImpl implements StudentService {
	@Autowired
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
		Student result = dao.readStuentByRollNumber(rollNumber);
		return result;
	}

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean updateStudentDetails(Student student) {
		int result = dao.updateStudent(student);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteStudentByRollNumber(int rollnumber) {
		int result = dao.deleteStudentByRollNumber(rollnumber);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<Student> AllStudent() {
		List<Student> list = new ArrayList<Student>();
		list = dao.AllStudents();
		return list;
	}

}
