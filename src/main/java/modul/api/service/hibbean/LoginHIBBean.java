package modul.api.service.hibbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * the Hibernate Bean for the user
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.2
 */
@Entity
@Table(name = "USER")
public class LoginHIBBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOGIN_ID")
	private Long loginId;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "ROLE")
	private String role;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LASTNAME")
	private String lastname;
	@OneToOne
	@JoinColumn(name="TEAMLEITER", nullable=false)
	private TeamHIBBean teamleiter;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private TeamHIBBean teammitglieder;
	
	public LoginHIBBean() {
		
	}
	
	public LoginHIBBean(String username, String role, String password, String email, String name, String lastname) {
		this.username = username;
		this.role = role;
		this.password = password;
		this.email = email;
		this.name = name;
		this.lastname = lastname;
	}

	public LoginHIBBean(Long loginId, String role) {
		this.loginId = loginId;
		this.role = role;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TeamHIBBean getTeamleiter() {
		return teamleiter;
	}

	public void setTeamleiter(TeamHIBBean teamleiter) {
		this.teamleiter = teamleiter;
	}

	public TeamHIBBean getTeammitglieder() {
		return teammitglieder;
	}

	public void setTeammitglieder(TeamHIBBean teammitglieder) {
		this.teammitglieder = teammitglieder;
	}
}
