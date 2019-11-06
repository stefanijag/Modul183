package modul.api.database.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import modul.api.database.repo.ProjectRepository;
import modul.api.service.api.ApiPersistenceAPI;
import modul.api.service.hibbean.ProjectHIBBean;


public class ApiPersistenceDBImpl implements ApiPersistenceAPI{
	
	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public Long updateProject(ProjectHIBBean projectHIBBean) throws Exception{
		try {
			return projectRepo.save(projectHIBBean).getProjectId();			
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public Optional<Iterable<ProjectHIBBean>> readAllProjects() throws Exception{
		try {
			return Optional.of(projectRepo.findAll());
		} catch(Exception e){
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public Optional<ProjectHIBBean> readProjectById(Long projectId) throws Exception{
		try {
			return projectRepo.findById(projectId);
		} catch(Exception e){
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public Long createProject(ProjectHIBBean projectHIBBean) throws Exception {
		try {
			return projectRepo.save(projectHIBBean).getProjectId();
		} catch(Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
	}

	@Override
	public void deleteProject(ProjectHIBBean projectHIBBean) throws Exception {
		try {
			projectRepo.delete(projectHIBBean);
		} catch(Exception e){
			throw new Exception(e.getMessage(), e);
		}
	}

}
