package modul.api.service;

import java.util.Optional;

import modul.api.service.hibbean.ProjectHIBBean;

public interface ApiService {
	
	Long updateProject(ProjectHIBBean projectHIBBean) throws Exception;
	Optional<Iterable<ProjectHIBBean>> readAllProjects() throws Exception;
	Optional<ProjectHIBBean> readProjectById(Long projectId) throws Exception;
	Long createProject(ProjectHIBBean projectHIBBean) throws Exception;
	void deleteProject(ProjectHIBBean projectHIBBean) throws Exception;
}
