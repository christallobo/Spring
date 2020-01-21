package com.lti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "HelloApp")
public class HelloRestController {
	// http://localhost:9091/HelloApp/hello
	// method:get
	@RequestMapping(path = "hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello from Rest Controller : get";
	}

	// http://localhost:9091/HelloApp/hello
	// method:post
	@RequestMapping(path = "hello", method = RequestMethod.POST)
	public String hello2() {
		return "Hello from Rest Controller : post";
	}
}
