package modul.api.service.api;

import java.util.Optional;

import modul.api.service.exception.ModulException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;

public interface ApiPersistenceAPI {
	
	//project
	Long updateProject(ProjectHIBBean projectHIBBean) throws ModulException;
	Optional<Iterable<ProjectHIBBean>> readAllProjects() throws ModulException;
	Optional<ProjectHIBBean> readProjectById(Long projectId) throws ModulException;
	Long createProject(ProjectHIBBean projectHIBBean) throws ModulException;
	void deleteProject(ProjectHIBBean projectHIBBean) throws ModulException;
	
	//login
	Long updateLogin(LoginHIBBean loginHIBBean) throws ModulException;
	String readLoginByUsernameAndPassword(String username, String password)throws ModulException;
	Long createAccount(LoginHIBBean loginHIBBean) throws ModulException;

}
