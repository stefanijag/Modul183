package modul.api.service.hibbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@Column(name = "ID")
	private Long teamId;
	@Column(name = "TEAMNAME")
	private String teamname;
	
	
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
}
