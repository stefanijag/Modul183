package modul.api.database.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modul.api.database.repo.LoginRepository;
import modul.api.database.repo.ProjectRepository;
import modul.api.service.api.ApiPersistenceAPI;
import modul.api.service.exception.ModulException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;

@Service
public class ApiPersistenceDBImpl implements ApiPersistenceAPI{
	
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public Long updateProject(ProjectHIBBean projectHIBBean) throws ModulException{
		try {
			return projectRepo.save(projectHIBBean).getProjectId();			
		} catch (Exception e) {
			throw new ModulException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<Iterable<ProjectHIBBean>> readAllProjects() throws ModulException{
		try {
			return Optional.of(projectRepo.findAll());
		} catch(Exception e){
			throw new ModulException(e.getMessage(), e);
		}
	}

	@Override
	public Optional<ProjectHIBBean> readProjectById(Long projectId) throws ModulException{
		try {
			return projectRepo.findById(projectId);
		} catch(Exception e){
			throw new ModulException(e.getMessage(), e);
		}
	}

	@Override
	public Long createProject(ProjectHIBBean projectHIBBean) throws ModulException {
		try {
			return projectRepo.save(projectHIBBean).getProjectId();
		} catch(Exception e){
			throw new ModulException(e.getMessage(), e);
		}
		
	}

	@Override
	public void deleteProject(ProjectHIBBean projectHIBBean) throws ModulException {
		try {
			projectRepo.delete(projectHIBBean);
		} catch(Exception e){
			throw new ModulException(e.getMessage(), e);
		}
	}

	@Override
	public Long updateLogin(LoginHIBBean loginHIBBean) throws ModulException {
		try {
			return loginRepo.save(loginHIBBean).getLoginId();
		}catch(Exception e) {
			throw new ModulException(e.getMessage(), e);
		}
	}

	@Override
	public String readLoginByUsernameAndPassword(String username, String password) throws ModulException {
		try{
			return loginRepo.loginByUsernameAndPassword(username, password);
		}catch(Exception e) {
			throw new ModulException(e.getMessage(), e);
		}
	}

	@Override
	public Long createAccount(LoginHIBBean loginHIBBean) throws ModulException {
		try {
			return loginRepo.save(loginHIBBean).getLoginId();
		}catch(Exception e) {
			throw new ModulException(e.getMessage(),e);
		}
	}

	@Override
	public Optional<LoginHIBBean> readLoginById(Long loginId) throws ModulException {
		try {
			return loginRepo.findById(loginId);
		} catch(Exception e){
			throw new ModulException(e.getMessage(), e);
		}
	}

}
