package modul.api.service;

import java.util.Optional;

import modul.api.service.bean.ProjectBean;
import modul.api.service.hibbean.ProjectHIBBean;

public interface ApiService {
	
	Long updateProject(ProjectBean projectBean) throws Exception;
	Optional<Iterable<ProjectHIBBean>> readAllProjects() throws Exception;
	Optional<ProjectHIBBean> readProjectById(Long projectId) throws Exception;
	Long createProject(ProjectBean projectBean) throws Exception;
	void deleteProject(ProjectBean projectBean) throws Exception;
}
