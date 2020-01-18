package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lti.model.Student;

@Repository
public class StudentDaoJdbcImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String CREATE_STUDENT = "insert into Student(Roll_Number,Student_Name,Student_Score)values(?,?,?)";
	private static final String READ_STUDENT = "select * from Student where roll_number=?";
	private static final String UPDATE_STUDENT="update Student set Student_Name=?,Student_Score=? where Roll_Number=?";
	private static final String DELETE_STUDENT="Delete from Student where Roll_Number=? ";
	private static final String ALL_STUDENT="select * from student";

	@Override
	public int createStudent(Student student) {
		int result = jdbcTemplate.update(CREATE_STUDENT, student.getRollNumber(), student.getStudentName(),student.getStudentScore());
		return result;
	}

	@Override
	public Student readStuentByRollNumber(int rollNumber) {
		// List<Student> students = jdbcTemplate.query(READ_STUDENT, new StudentRowMapper());
		Student result = jdbcTemplate.queryForObject(READ_STUDENT,new Object[]{rollNumber},new StudentRowMapper() );
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int updateStudent(Student student) {
		int result=jdbcTemplate.update(UPDATE_STUDENT,student.getStudentName(),student.getStudentScore(),student.getRollNumber());
		return result;
	}

	@Override
	public int deleteStudentByRollNumber(int rollNumber) {
		int result=jdbcTemplate.update(DELETE_STUDENT,rollNumber);
		return result;
	}

	@Override
	public List<Student> AllStudents() {
		List<Student> list=new ArrayList<Student>();
		list=jdbcTemplate.query(ALL_STUDENT, new StudentRowMapper());
		return list;
	}

}
