package com.example.demo;
import com.example.demo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUp {
	@Autowired
	private UserService userService;

//	@GetMapping("/checkBenutzername")
//	public String checkBenutzername(@RequestParam("username") String username) {
//		// Validiere die Benutzerdaten
//		if (userService.isUsableID(username)) {
//			return "Benutzername ist verfügbar";
//		} else {
//			return "Benutzername bereits vergeben";
//		}
//	}

	@PostMapping("/register")
	public String registrieren(  @RequestParam("benutzername") String benutzername,
            @RequestParam("password") String password,
            @RequestParam("passwordRepeat") String passwordRepeat,
            @RequestParam("email") String email,
            @RequestParam("vorname") String vorname,
            @RequestParam("nachname") String nachname,
            @RequestParam("geburtsdatum") String geburtsdatum,
            @RequestParam("adresse") String adresse,
            @RequestParam("stadt") String stadt,
            @RequestParam("PLZ") String PLZ,
            @RequestParam("land") String land,
            @RequestParam("frage") String frage,
            @RequestParam("antwort") String antwort,
            Model model)  {
		
		//wenn passwort!=wederholpasswort ist, soll die register form mit schon angegebene info bleiben.
		//aber es funktuniert nicht. es ruft zwar register aber die Info werden nicht ausgefuellt
		if (!password.equals(passwordRepeat)) {
		    model.addAttribute("error", "Passwörter stimmen nicht überein.");
		    model.addAttribute("benutzername", benutzername);
		    model.addAttribute("email", email);
		    model.addAttribute("vorname", vorname);
		    model.addAttribute("nachname", nachname);
		    model.addAttribute("geburtsdatum", geburtsdatum);
		    model.addAttribute("adresse", adresse);
		    model.addAttribute("stadt", stadt);
		    model.addAttribute("PLZ", PLZ);
		    model.addAttribute("land", land);
		    model.addAttribute("antwort", antwort);
		    return "register";

		} else if (!userService.isUsableID(benutzername)) {
		    model.addAttribute("error", "Benutzername ist bereits vorhanden.");
		    model.addAttribute("benutzername", benutzername);
		    model.addAttribute("email", email);
		    model.addAttribute("vorname", vorname);
		    model.addAttribute("nachname", nachname);
		    model.addAttribute("geburtsdatum", geburtsdatum);
		    model.addAttribute("adresse", adresse);
		    model.addAttribute("stadt", stadt);
		    model.addAttribute("PLZ", PLZ);
		    model.addAttribute("land", land);
		    model.addAttribute("antwort", antwort);
		    return "register";
		    
		}
else {
		//wenn es sicher ist, dass Registrierung durchgefuhrt werden kann. 
	//dann die frage gleicher form vom SQL enum umgewandelt.
		switch(frage) {
		case "Film":frage="lieblings Film";
		case "Haustier":frage="Name ersten Haustiers";
		case "Musiker": frage="Lieblings Musiker";
		}

		UserForm userForm=new UserForm( benutzername,  password, vorname,  nachname,  email,
                 adresse,  stadt,  PLZ,  land,  antwort,  geburtsdatum,  frage);
		
		// fuege den Benutzer zur Datenbank hinzu
		userService.registerUser(userForm);

		
		// Weiterleitung zur sucess seite und die seite wird nach 5 sekunde zur Anmeldeseite weiterleten
		return "redirect:/successful";
		}
	}
}
