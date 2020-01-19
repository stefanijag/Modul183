package modul.api.service.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * the user interface Bean for registration
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.2
 */
public class RegisterUIBean {

	@NotBlank(message = "Bitte geben Sie ihren Namen ein")
	private String name;
	@NotBlank(message = "Bitte geben Sie ihren Nachnamen ein")
	private String lastname;
	@NotBlank(message = "Bitte geben Sie einen Usernamen ein")
	private String username;
	@Pattern(regexp = "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%+]).{8,})")
	@NotBlank(message = "Bitte geben Sie ein Passwort ein")
	private String password;
	@NotBlank(message = "Bitte bestätigen Sie Ihr Passwort")
	private String confirmPassword;
	@NotBlank(message = "Bitte geben Sie Ihre E-Mail Adresse ein")
	//Zwischen dem @ muss es zeichen geben
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message="Ungueltige E-Mail!") // Noed sicher obs guet isch
	private String email;
	private String role = "US";

	
	public RegisterUIBean () {
		
	}
	
	public RegisterUIBean(@NotBlank(message = "Bitte geben Sie ihren Namen ein") String name,
			@NotBlank(message = "Bitte geben Sie ihren Nachnamen ein") String lastname,
			@NotBlank(message = "Bitte geben Sie einen Usernamen ein") String username,
			@Pattern(regexp = "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%+]).{8,})") @NotBlank(message = "Bitte geben Sie ein Passwort ein") String password,
			@NotBlank(message = "Bitte bestätigen Sie Ihr Passwort") String confirmPassword,
			@NotBlank(message = "Bitte geben Sie Ihre E-Mail Adresse ein") @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Ungueltige E-Mail!") String email,
			String role) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.role = role;
	}

	//Getter and setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
