package modul.api.service;

import java.util.Optional;

import modul.api.service.bean.ProjectBean;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;
import modul.api.service.hibbean.TeamHIBBean;
/**
 * Interface for all needed database statements controller level
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
public interface ApiService {

	//project
	Long updateProject(ProjectBean projectBean) throws ProjectCollectorException;

	Optional<Iterable<ProjectHIBBean>> readAllProjects() throws ProjectCollectorException;

	Optional<ProjectHIBBean> readProjectById(Long projectId) throws ProjectCollectorException;

	Long createProject(ProjectBean projectBean) throws ProjectCollectorException;

	void deleteProject(ProjectBean projectBean) throws ProjectCollectorException;

	// login
	Long updateLogin(LoginHIBBean loginHIBBean) throws ProjectCollectorException;

	String readLoginByUsernameAndPassword(String username, String password) throws ProjectCollectorException;

	Long createAccount(LoginHIBBean loginHIBBean) throws ProjectCollectorException;
	
	Optional<LoginHIBBean> readLoginById(Long loginId) throws ProjectCollectorException;
	
	Optional<Iterable<LoginHIBBean>> readAllLogin() throws ProjectCollectorException;
	
	//Team
	Optional <Iterable<TeamHIBBean>> readAllTeams() throws ProjectCollectorException;
	Optional <TeamHIBBean> readTeamById(Long teamId) throws ProjectCollectorException;
	
}
