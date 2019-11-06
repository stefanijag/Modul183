package modul.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import modul.api.service.ApiService;
import modul.api.service.api.ApiPersistenceAPI;
import modul.api.service.hibbean.ProjectHIBBean;

public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private ApiPersistenceAPI persistence;

	@Override
	public Long updateProject(ProjectHIBBean projectHIBBean) throws Exception {
		return persistence.updateProject(projectHIBBean);
	}

	@Override
	public Optional<Iterable<ProjectHIBBean>> readAllProjects() throws Exception {
		return persistence.readAllProjects();
	}

	@Override
	public Optional<ProjectHIBBean> readProjectById(Long projectId) throws Exception {
		return persistence.readProjectById(projectId);
	}

	@Override
	public Long createProject(ProjectHIBBean projectHIBBean) throws Exception {
		return persistence.createProject(projectHIBBean);
	}

	@Override
	public void deleteProject(ProjectHIBBean projectHIBBean) throws Exception {
		persistence.deleteProject(projectHIBBean);
	}
	
}
