package modul.api.service.impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modul.api.service.ApiService;
import modul.api.service.api.ApiPersistenceAPI;
import modul.api.service.bean.ProjectBean;
import modul.api.service.hibbean.ProjectHIBBean;

@Service
public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private ApiPersistenceAPI persistence;

	@Override
	public Long updateProject(ProjectBean projectBean) throws Exception {
		return persistence.updateProject(new ProjectHIBBean(projectBean.getProjectName(), Date.valueOf(projectBean.getReleaseDate()), projectBean.getDescription()));
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
	public Long createProject(ProjectBean projectBean) throws Exception {
		return persistence.createProject(new ProjectHIBBean(projectBean.getProjectName(), Date.valueOf(projectBean.getReleaseDate()), projectBean.getDescription()));
	}

	@Override
	public void deleteProject(ProjectBean projectBean) throws Exception {
		persistence.deleteProject(new ProjectHIBBean(projectBean.getProjectName(), Date.valueOf(projectBean.getReleaseDate()), projectBean.getDescription()));
	}
	
}
