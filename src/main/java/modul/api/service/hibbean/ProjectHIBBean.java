package modul.api.service.hibbean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
@Table(name = "PROJECT")
public class ProjectHIBBean {
	@Id
	@GeneratedValue
	@Column(name = "PROJECT_ID")
	private Long projectId;
	@Column(name = "PROJECTNAME")
	private String projectName;
	@Column(name = "RELEASEDATE")
	private Date releaseDate;
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinTable(name = "TEAM_ID")
	private TeamHIBBean team;
	
	public ProjectHIBBean() {
		
	}
	
	public ProjectHIBBean(String projectName, Date releaseDate, String description, TeamHIBBean team) {
		this.projectName = projectName;
		this.releaseDate = releaseDate;
		this.description = description;
		this.team = team;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public TeamHIBBean getTeam() {
		return team;
	}

	public void setTeam(TeamHIBBean team) {
		this.team = team;
	}
}
