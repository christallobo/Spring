package com.lti.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Student student = context.getBean("student", Student.class);

		// default scope is singleton
		System.out.println(student);
		System.out.println(student.getAddress());
		context.close();
	}

}
