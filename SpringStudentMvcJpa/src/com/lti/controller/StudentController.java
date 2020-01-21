
package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.model.Student;
import com.lti.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	@Autowired
	private ApplicationContext context;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}

	@RequestMapping(path = "addStudent.view", method = RequestMethod.GET)
	public String addStudentView() {
		return "addStudent";
	}

	@RequestMapping(path = "addStudent.do", method = RequestMethod.POST)
	public String addStudent(@RequestParam("rollNumber") int rollNumber,
							 @RequestParam("studentName") String name,
							 @RequestParam("studentScore") double score) {
	//public String addStudent(Student student) {
		// String rollNumber=request.getParameter("rollNumber");//there is no
		// need to do all these this is done by spring
		Student student=context.getBean(Student.class);
		student.setRollNumber(rollNumber);
		student.setStudentName(name);
		student.setStudentScore(score);
		boolean result = service.addStudent(student);
		if (result) {
			return "redirect:findAllStudents.do";
		} else {
			return "error";
		}

	}

	@RequestMapping(path = "findAllStudents.do", method = RequestMethod.GET)
	public String findAllStudents(Model model) {
		List<Student> students = service.AllStudent();
		model.addAttribute("students",students);
		return "ViewAllStudents";
	}
	
	
	@RequestMapping(path="updateStudent.view",method=RequestMethod.GET)
	public String updateStudentView(){
		return "updateStudent";
	}
	
	@RequestMapping(path="updateStudent.do",method=RequestMethod.POST)
	public String updateStudent(Student student){
		boolean result=service.updateStudentDetails(student);
		if(result){
			return "redirect:findAllStudents.do";
		}
		else{
			return "error";
		}
	}
	@RequestMapping(path="deleteStudent.view",method=RequestMethod.GET)
	public String deleteStudentview(){
		return "deleteStudent";
	}
	
	@RequestMapping(path="deleteStudent.do",method=RequestMethod.POST)
	public String deleteStudent(HttpServletRequest request){
		//boolean result=service.deleteStudentByRollNumber(student.getRollNumber());
		String rollNumber=request.getParameter("rollNumber");
		Integer rollNum=Integer.parseInt(rollNumber);
//		System.out.println(rollNum);
		boolean result=service.deleteStudentByRollNumber(rollNum);
		if(result){
			return "redirect:findAllStudents.do";
		}
		else{
			return "error";
		}
	}
}
