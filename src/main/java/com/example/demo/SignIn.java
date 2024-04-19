package com.example.demo;

import com.example.demo.*;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignIn {
	@Autowired
	private UserService userService;
	private UserForm user;

	@PostMapping("/login")
	public String signIn(@RequestParam("id") String id, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes) {
		if (userService.authenticateUser(id, password)) {
			user.setBenutzername(id);
			ShowDashboard showDashboard = new ShowDashboard(user); //gib user weiter
			return "redirect:/dashboard";
		} else {
			redirectAttributes.addFlashAttribute("showLabel", true);
			return "redirect:/login";
		}
	}

}
