package modul.api.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modul.api.service.ApiService;
import modul.api.service.api.ApiPersistenceAPI;
import modul.api.service.bean.ProjectBean;
import modul.api.service.bean.TeamBean;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;
import modul.api.service.hibbean.TeamHIBBean;

/**
 * Implementation for all needed database statements controller level
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
@Service
public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private ApiPersistenceAPI persistence;

	@Override
	public Long updateProject(ProjectBean projectBean) throws ProjectCollectorException {
		return persistence.updateProject(new ProjectHIBBean(projectBean.getProjectName(), Date.valueOf(projectBean.getReleaseDate()), projectBean.getDescription(), castProject(projectBean)));
	}

	private List<TeamHIBBean> castProject(ProjectBean projectBean) {
		List<TeamBean> developerteam = projectBean.getDeveloperteam();
		List<TeamHIBBean> teams = new ArrayList<>();
		for(TeamBean bean : developerteam) {
			teams.add(new TeamHIBBean(bean.getTeamId()));
		}
		return teams;
	}

	@Override
	public Optional<Iterable<ProjectHIBBean>> readAllProjects() throws ProjectCollectorException {
		return persistence.readAllProjects();
	}

	@Override
	public Optional<ProjectHIBBean> readProjectById(Long projectId) throws ProjectCollectorException {
		return persistence.readProjectById(projectId);
	}

	@Override
	public Long createProject(ProjectBean projectBean) throws ProjectCollectorException {
		return persistence.createProject(new ProjectHIBBean(projectBean.getProjectName(), Date.valueOf(projectBean.getReleaseDate()), projectBean.getDescription(), castProject(projectBean)));
	}

	@Override
	public void deleteProject(ProjectBean projectBean) throws ProjectCollectorException {
		persistence.deleteProject(new ProjectHIBBean(projectBean.getProjectName(), Date.valueOf(projectBean.getReleaseDate()), projectBean.getDescription(), castProject(projectBean)));
	}

	@Override
	public Long updateLogin(LoginHIBBean loginHIBBean) throws ProjectCollectorException {
		return persistence.updateLogin(loginHIBBean);
	}

	@Override
	public String readLoginByUsernameAndPassword(String username, String password) throws ProjectCollectorException {
		return persistence.readLoginByUsernameAndPassword(username, password);
	}

	@Override
	public Long createAccount(LoginHIBBean loginHIBBean) throws ProjectCollectorException {
		return persistence.createAccount(loginHIBBean);
	}

	@Override
	public Optional<LoginHIBBean> readLoginById(Long loginId) throws ProjectCollectorException {
		return persistence.readLoginById(loginId);
	}

	@Override
	public Optional<Iterable<LoginHIBBean>> readAllLogin() throws ProjectCollectorException {
		return persistence.readAllLogin();
	}
	
}
