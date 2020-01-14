package modul.api.service.bean;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * the Bean for project
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.2
 */
public class ProjectBean {
	
	private Long projectId;
	@NotBlank(message="Bitte geben Sie einen Projektnamen ein")
	@Size(min=3, max=50, message="Projektname soll mindestens 3 und nicht mehr als 50 Zeichen enthalten")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Projektname darf nur Nummern und Buchstaben beinhalten")
	private String projectName;
	@NotBlank(message="Bitte wählen Sie ein Release Datum aus")
	private String releaseDate;
	@NotBlank(message="Bitte geben Sie einen Beschreibung ein")
	@Size(min=3, max=250, message="Die Beschreibung muss mindestens drei Zeichen und kann höchstens 250 enthalten!")
	private String description;
	private List<TeamBean> developerteam;

	//Getter and setter
	
	public List<TeamBean> getDeveloperteam() {
		return developerteam;
	}

	public void setDeveloperteam(List<TeamBean> developerteam) {
		this.developerteam = developerteam;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
