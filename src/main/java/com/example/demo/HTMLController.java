package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@Controller
public class HTMLController {

	@GetMapping("/hello")
	public String hello() {
		
		return "hello"; 
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register"; 
	}
	
	@GetMapping("/")
	public String login() {
	
		return "login"; 
	}
	
	@GetMapping("/login")
	public String login2() {
	
		return "login"; 
	}
	@GetMapping("/dashboard")
	public String dashboard() {
	
		return "dashboard";
}
	@GetMapping("/successful")
	public String successful() {
	
		return "successful";
}
}
