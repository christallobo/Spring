package com.lti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lti.model.Address;
import com.lti.model.Student;

@Configuration
@ComponentScan(basePackages = "com.lti.model")
public class AppConfig {
	@Bean(name = "address1")
	public Address getAddress() {
		Address address = new Address();
		address.setCity("NaviMumbai");
		return address;
	}
}
