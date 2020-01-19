package modul.api.service.hibbean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * the Hibernate Bean for the projects
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.2
 */
@Entity
@Table(name = "TEAM")
public class TeamHIBBean {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long teamId;
	@Column(name = "TEAMNAME")
	private String teamname;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<LoginHIBBean> userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "TEAMLEITER")
	private LoginHIBBean teamleiter;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "PROJECT_ID")
	private List<ProjectHIBBean>  projects;
	
	public TeamHIBBean() {
		
	}
	
	public TeamHIBBean(Long teamId) {
		this.teamId = teamId;
	}
	
	public TeamHIBBean(Long teamId, String teamname, List<LoginHIBBean> userId, LoginHIBBean teamleiter,
			List<ProjectHIBBean> projects) {
		super();
		this.teamId = teamId;
		this.teamname = teamname;
		this.userId = userId;
		this.teamleiter = teamleiter;
		this.projects = projects;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public List<LoginHIBBean> getUserId() {
		return userId;
	}
	public void setUserId(List<LoginHIBBean> userId) {
		this.userId = userId;
	}
	public LoginHIBBean getTeamleiter() {
		return teamleiter;
	}
	public void setTeamleiter(LoginHIBBean teamleiter) {
		this.teamleiter = teamleiter;
	}
	public List<ProjectHIBBean> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectHIBBean> projects) {
		this.projects = projects;
	}
}
