package com.lti.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Student;
import com.lti.service.StudentService;

public class Main2 {
	private static ApplicationContext context;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentService service = getContext().getBean("service", StudentService.class);

		boolean flag = true;
		do {
			System.out.println("1.Add student");
			System.out.println("2.Find student");
			System.out.println("3.Modify student");
			System.out.println("4.Delete student");
			System.out.println("5.Details about all Students");
			System.out.println("0.Exit Application");
			System.out.println("Enter your choice");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Student Roll Number:");
				int rollNumber = scan.nextInt();
				System.out.println("Enter Student Name:");
				String studentName = scan.next();
				System.out.println("Enter Student Score:");
				double studentScore = scan.nextDouble();

				Student student = getContext().getBean("student", Student.class);
				student.setRollNumber(rollNumber);
				student.setStudentName(studentName);
				student.setStudentScore(studentScore);

				boolean result = service.addStudent(student);
				if (result) {
					System.out.println("Student with rollnumber " + student.getRollNumber() + " is added successfully.");
				} else {
					System.out.println("There is some technical problem.Please Try Again!!!");
				}
				System.out.println();
				break;
			case 2:
				System.out.println("enter the roll number");
				rollNumber=scan.nextInt();
				Student student1=service.findStudentByRollNumber(rollNumber);
				System.out.println(student1);
				System.out.println();
				break;
			case 3:
				System.out.println("Enter Student Roll Number:");
				rollNumber = scan.nextInt();
				System.out.println("Enter Student Name:");
				studentName = scan.next();
				System.out.println("Enter Student Score:");
				studentScore = scan.nextDouble();
				
				student = getContext().getBean("student", Student.class);
				student.setRollNumber(rollNumber);
				student.setStudentName(studentName);
				student.setStudentScore(studentScore);
				
				result=service.updateStudentDetails(student);
				if(result){
					System.out.println("Student with rollnumber " + student.getRollNumber() + " is updated successfully.");
				}
				else{
					System.out.println("There is some technical problem.Please Try Again!!!");
				}
				break;
			case 4:
				System.out.println("Enter Student Roll Number:");
				rollNumber = scan.nextInt();
				
				result=service.deleteStudentByRollNumber(rollNumber);
				if(result){
					System.out.println("Student is deleted successfully.");
				}
				else{
					System.out.println("There is some technical problem.Please Try Again!!!");
				}
				break;
			case 5:
				List<Student> list=service.AllStudent();
				for(Student s:list){
					System.out.println(s.getRollNumber()+" "+s.getStudentName()+" "+s.getStudentScore());
				}
				break;
			case 0:
				flag = false;
			}
		} while (flag);
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext context) {
		Main2.context = context;
	}
	
}
