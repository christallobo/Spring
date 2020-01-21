package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Student;
import com.lti.service.StudentService;

@RestController
@RequestMapping(path = "students")
@CrossOrigin
public class StudentRestController {
	@Autowired
	private StudentService service;

	// http://localhost:9091/students
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findAllStudents() {
		List<Student> students = service.AllStudent();
		return students;
	}

	// http://localhost:9091/students/30
	@RequestMapping(path = "{rollno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student findStudentByRollNumber(@PathVariable("rollno") int rollNumber) {
		Student student = service.findStudentByRollNumber(rollNumber);
		return student;
	}

	// http://localhost:9091/students
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student) {
		service.addStudent(student);
	}

	@RequestMapping(path="{rollNumber}",method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("rollNumber") int rollNumber) {
		boolean result = service.deleteStudentByRollNumber(rollNumber);
	}
	// http://localhost:9091/students
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student) {
		boolean result = service.updateStudentDetails(student);
	}
	
	
}
