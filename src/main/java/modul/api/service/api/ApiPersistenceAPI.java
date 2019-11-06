package modul.api.service.api;

import java.util.Optional;

import modul.api.service.hibbean.ProjectHIBBean;

public interface ApiPersistenceAPI {
	
	Long updateProject(ProjectHIBBean projectHIBBean) throws Exception;
	Optional<Iterable<ProjectHIBBean>> readAllProjects() throws Exception;
	Optional<ProjectHIBBean> readProjectById(Long projectId) throws Exception;
	Long createProject(ProjectHIBBean projectHIBBean) throws Exception;
	void deleteProject(ProjectHIBBean projectHIBBean) throws Exception;

}
