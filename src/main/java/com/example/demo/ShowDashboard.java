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
	public ShowDashboard(UserForm user) {
		this.user = user;
	}

	@GetMapping("/dashboard")
	public String  displayDashboard(Model model) {
		String username = user.getBenutzername();
		String[] values = new String[user.variableNames.length];


		for(int i=0;i<user.variableNames.length;i++) {
			values[i]=userService.findById(username,user.variableNames[i]);
		}
		//ERROR
		 // Füge jeden Wert einzeln zum Modell hinzu
        model.addAttribute("username", username);
        model.addAttribute("email", values[4]);
        model.addAttribute("firstName", values[2]);
        model.addAttribute("lastName", values[3]);
        model.addAttribute("birthdate", values[10]);
        model.addAttribute("address", values[5]);
        model.addAttribute("city", values[6]);
        model.addAttribute("postalCode", values[7]);
        model.addAttribute("country", values[8]);
        model.addAttribute("securityQuestion", values[11]);
        model.addAttribute("securityAnswer", values[9]);
        return "dashboard"; // Name der HTML-Datei im `src/main/resources/templates` Verzeichnis

	}
}
