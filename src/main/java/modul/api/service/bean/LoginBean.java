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
	private String role;

	//Getter and setter
	
	
	
	public LoginBean(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginBean(@NotBlank(message = "Bitte alle Felder ausfüllen!") String username,
			@NotBlank(message = "Bitte alle Felder ausfüllen!") String password, Long loginId, String role) {
		super();
		this.username = username;
		this.password = password;
		this.loginId = loginId;
		this.role = role;
	}

	public LoginBean() {
		// TODO Auto-generated constructor stub
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

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
