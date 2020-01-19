package modul.api.database.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modul.api.database.repo.LoginRepository;
import modul.api.database.repo.ProjectRepository;
import modul.api.database.repo.TeamRepository;
import modul.api.service.api.ApiPersistenceAPI;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;
import modul.api.service.hibbean.TeamHIBBean;

/**
 * Implementation for all needed database statements database level
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
@Service
public class ApiPersistenceDBImpl implements ApiPersistenceAPI{
	
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private LoginRepository loginRepo;
	@Autowired
	private TeamRepository teamRepo;

	@Override
	public Long updateProject(ProjectHIBBean projectHIBBean) throws ProjectCollectorException{
		try {
			return projectRepo.save(projectHIBBean).getProjectId();			
		} catch (Exception e) {
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<Iterable<ProjectHIBBean>> readAllProjects() throws ProjectCollectorException{
		try {
			return Optional.of(projectRepo.findAll());
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<ProjectHIBBean> readProjectById(Long projectId) throws ProjectCollectorException{
		try {
			return projectRepo.findById(projectId);
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Long createProject(ProjectHIBBean projectHIBBean) throws ProjectCollectorException {
		try {
			return projectRepo.save(projectHIBBean).getProjectId();
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
		
	}

	@Override
	public void deleteProject(ProjectHIBBean projectHIBBean) throws ProjectCollectorException {
		try {
			projectRepo.delete(projectHIBBean);
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Long updateLogin(LoginHIBBean loginHIBBean) throws ProjectCollectorException {
		try {
			return loginRepo.save(loginHIBBean).getLoginId();
		}catch(Exception e) {
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public String readLoginByUsernameAndPassword(String username, String password) throws ProjectCollectorException {
		try{
			return loginRepo.loginByUsernameAndPassword(username, password);
		}catch(Exception e) {
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Long createAccount(LoginHIBBean loginHIBBean) throws ProjectCollectorException {
		try {
			return loginRepo.save(loginHIBBean).getLoginId();
		}catch(Exception e) {
			throw new ProjectCollectorException(e.getMessage(),e);
		}
	}

	@Override
	public Optional<LoginHIBBean> readLoginById(Long loginId) throws ProjectCollectorException {
		try {
			return loginRepo.findById(loginId);
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<Iterable<LoginHIBBean>> readAllLogin() throws ProjectCollectorException {
		try {
			return Optional.of(loginRepo.findAll());
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<Iterable<TeamHIBBean>> readAllTeam() throws ProjectCollectorException {
		try {
			return Optional.of(teamRepo.findAll());
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<TeamHIBBean> readTeamById(Long teamId) throws ProjectCollectorException {
		try {
			return teamRepo.findById(teamId);
		} catch(Exception e){
			throw new ProjectCollectorException(e.getMessage(), e);
		}
	}

}
