package com.example.demo;

public class UserForm {
	
	UserService userService;

	//alle columns in SQL
	public String[] variableNames = { "benutzername", "password", "vorname", "nachname", "email", "adresse", "stadt",
			"PLZ", "land", "antwort", "geburtsdatum", "frage" };
	private String benutzername,  password, vorname,  nachname,  email,
    adresse,  stadt,  PLZ,  land,  antwort,  geburtsdatum,  frage;

	// Konstruktor, der alle Felder setzt
	public UserForm(String benutzername, String password, String vorname, String nachname, String email, String adresse,
			String stadt, String PLZ, String land, String antwort, String geburtsdatum, String frage) {
		this.benutzername = benutzername;
		this.password = password;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.adresse = adresse;
		this.stadt = stadt;
		this.PLZ = PLZ;
		this.land = land;
		this.antwort = antwort;
		this.geburtsdatum = geburtsdatum;
		this.frage = frage;
	}
	
	//Konstuktor mit username
	public UserForm(String benutzername) {
		this.benutzername=userService.findById(benutzername, variableNames[0]);
		this.password=userService.findById(benutzername, variableNames[1]);
		this.vorname=userService.findById(benutzername, variableNames[2]);
		this.nachname=userService.findById(benutzername, variableNames[3]);
		this.email=userService.findById(benutzername, variableNames[4]);
		this.adresse=userService.findById(benutzername, variableNames[5]);
		this.stadt=userService.findById(benutzername, variableNames[6]);
		this.PLZ=userService.findById(benutzername, variableNames[7]);
		this.land=userService.findById(benutzername, variableNames[8]);
		this.antwort=userService.findById(benutzername, variableNames[9]);
		this.geburtsdatum=userService.findById(benutzername, variableNames[10]);
		this.frage=userService.findById(benutzername, variableNames[11]);
		
		
	}

	public String getBenutzername() {
		return benutzername;
	}

	public String getPassword() {
		return password;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getEmail() {
		return email;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getStadt() {
		return stadt;
	}

	public String getPLZ() {
		return PLZ;
	}

	public String getLand() {
		return land;
	}

	public String getAntwort() {
		return antwort;
	}

	public String getGEB() {
		return geburtsdatum;
	}

	public String getFrage() {
		return frage;
	}

	public String setBenutzername(String benutzername) {
		return this.benutzername = benutzername;
	}

	public String setPassword(String password) {
		return this.password = password;
	}

	public String setVorname(String vorname) {
		return this.vorname = vorname;
	}

	public String setNachname(String nachname) {
		return this.nachname = nachname;
	}

	public String setEmail(String email) {
		return this.email = email;
	}

	public String setAdresse(String adresse) {
		return this.adresse = adresse;
	}

	public String setStadt(String stadt) {
		return this.stadt = stadt;
	}

	public String setPLZ(String PLZ) {
		return this.PLZ = PLZ;
	}

	public String setLand(String land) {
		return this.land = land;
	}

	public String setAntwort(String antwort) {
		return this.antwort = antwort;
	}

	public String setGEB(String geburtsdatum) {
		return this.geburtsdatum = geburtsdatum;
	}

	public String setFrage(String frage) {
		return this.frage = frage;
	}
}
