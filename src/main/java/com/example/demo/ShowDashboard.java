package com.example.demo;

import com.example.demo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

public class ShowDashboard {
	private UserForm user;
	@Autowired
	private UserService userService;
	private String username;

	public ShowDashboard(String userID) {
		username = userID;
	}

	@GetMapping("/dashboard")
	public String displayDashboard(Model model) {
		user = new UserForm(username); //mit username neue user setzen
		model.addAttribute("username", username);
//		model.addAttribute("email", user.getEmail());
//		model.addAttribute("firstName", user.getVorname());
//		model.addAttribute("lastName", user.getNachname());
//		model.addAttribute("birthdate", user.getGEB());
//		model.addAttribute("address", user.getAdresse());
//		model.addAttribute("city", user.getStadt());
//		model.addAttribute("postalCode", user.getPLZ());
//		model.addAttribute("country", user.getLand());
//		model.addAttribute("securityQuestion", user.getFrage());
//		model.addAttribute("securityAnswer", user.getAntwort());
		return "dashboard";

	}
}
