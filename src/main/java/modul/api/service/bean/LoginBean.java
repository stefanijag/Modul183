package modul.api.service.bean;

import javax.validation.constraints.NotBlank;
/**
 * the Bean for login
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.2
 */
public class LoginBean {
	@NotBlank(message="Bitte alle Felder ausfüllen!")
	private String username;
	@NotBlank(message="Bitte alle Felder ausfüllen!")
	private String password;
	private Long loginId;

	//Getter and setter
	
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

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
}
