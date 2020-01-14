package modul.api.service.hibbean;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "TEAM_ID")
	private List<TeamHIBBean> teams;
	
	public ProjectHIBBean() {
		
	}
	
	public ProjectHIBBean(String projectName, Date releaseDate, String description, List<TeamHIBBean> teams) {
		this.projectName = projectName;
		this.releaseDate = releaseDate;
		this.description = description;
		this.teams = teams;
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

	public List<TeamHIBBean> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamHIBBean> teams) {
		this.teams = teams;
	}
}
