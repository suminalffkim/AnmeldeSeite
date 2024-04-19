package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@Controller
public class HTMLController {

	@GetMapping("/hello")
	public String hello() {
		
		return "hello"; // Gibt den Namen der HTML-Datei zurück (ohne Erweiterung), die gerendert werden
						// soll
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register"; // Gibt den Namen der HTML-Datei zurück (ohne Erweiterung), die gerendert werden
						// soll
	}
	
	@GetMapping("/login")
	public String login() {
	
		return "login"; // Gibt den Namen der HTML-Datei zurück (ohne Erweiterung), die gerendert werden
						// soll
	}
	@GetMapping("/dashboard")
	public String dashboard() {
	
		return "dashboard"; // Gibt den Namen der HTML-Datei zurück (ohne Erweiterung), die gerendert werden
						// soll
	}
}
