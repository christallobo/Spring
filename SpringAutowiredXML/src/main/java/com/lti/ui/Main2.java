package com.lti.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.model.Address;
import com.lti.model.Student;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		Student student = (Student) context.getBean("student");
		Student student1 = (Student) context.getBean("student2");
		Student student3 = (Student) context.getBean("student3");
		
		System.out.println(student);
		System.out.println(student.getAddress());
		//System.out.println(student.getAddress2());
		System.out.println();
		
		System.out.println(student1);
		System.out.println(student1.getAddress());
		System.out.println();
		
		System.out.println(student3);
		System.out.println(student3.getAddress());
		System.out.println();
	}

}
