package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

@Service
public class UserService {//class fuer sql connection

	// JDBC-Verbindungsdaten
	private static final String url = "jdbc:mysql://localhost:3306/anmeldeliste";
	private static final String user = "project";
	private static final String SQLpassword = "pwd";

	// SQL-Abfrage
	private static final String query = "SELECT * FROM benutzer";

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(url, user, SQLpassword);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				String userId = rs.getString("benutzername");
				String firstname = rs.getString("Vorname");
				String surname = rs.getString("Nachname");
			}
		} catch (SQLException e) {
			System.out.println("Fehler beim Herstellen der Verbindung zur Datenbank: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean authenticateUser(String username, String password) {
		//um anmelde daten zu ueberprefen.
		String query = "SELECT * FROM benutzer WHERE benutzername = '" + username + "' AND passwort = '" + password
				+ "'";
		try (Connection con = DriverManager.getConnection(url, user, SQLpassword);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			// Wenn ein Datensatz gefunden wird, sind die Anmeldeinformationen korrekt
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isUsableID(String username) {
		//ueberprueft ob die benutzername schon vorhanden ist
		String query = "SELECT * FROM benutzer WHERE benutzername = '" + username + "'";
		try (Connection con = DriverManager.getConnection(url, user, SQLpassword);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			return !rs.next(); //nur wenn benutzername nicht vorhanden ist, kann man registrieren
		} catch (SQLException e) {

			e.printStackTrace();
			return true;
		}
	}

	public static void registerUser(UserForm userForm) {
		String query = "INSERT INTO benutzer (benutzername, passwort, email, Vorname, Nachname,geburtsdatum,adresse,stadt,PLZ,land,frage,antwort) "
				+ "VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?)";
		try (Connection con = DriverManager.getConnection(url, user, SQLpassword);
				PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

			// Setze die Werte für die Parameter im SQL-Query
			pstmt.setString(1, userForm.getBenutzername());
			pstmt.setString(2, userForm.getPassword());
			pstmt.setString(3, userForm.getEmail());
			pstmt.setString(4, userForm.getVorname());
			pstmt.setString(5, userForm.getNachname());
			pstmt.setString(6, userForm.getGEB());
			pstmt.setString(7, userForm.getAdresse());
			pstmt.setString(8, userForm.getStadt());
			pstmt.setString(9, userForm.getPLZ());
			pstmt.setString(10, userForm.getLand());
			pstmt.setString(11, userForm.getFrage());
			pstmt.setString(12, userForm.getAntwort());

			// Führe das SQL-Query aus, um den Benutzer in die Datenbank einzufügen
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Fehler beim Einfügen des Benutzers, keine Zeile betroffen.");
			}

			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					// Hier können Sie die automatisch generierte ID abrufen, wenn benötigt
					long id = generatedKeys.getLong(1);
					System.out.println("Benutzer erfolgreich registriert. (ID: " + id + ")");
				} else {
					throw new SQLException("Fehler beim Einfügen des Benutzers, keine ID erhalten.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Fehler beim Registrieren des Benutzers.");
		}
	}

	public String findById(String username, String attribute) {
		String query = "SELECT"+attribute+" FROM benutzer WHERE benutzername = '" + username + "'";
		try (Connection con = DriverManager.getConnection(url, user, SQLpassword);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			// Wenn ein Datensatz gefunden wird, sind die Anmeldeinformationen korrekt
			if (rs.next()) {
				return rs.getString(attribute);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
