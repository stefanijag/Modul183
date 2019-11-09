package modul.api.service;

import java.util.Optional;

import modul.api.service.bean.ProjectBean;
import modul.api.service.exception.ModulException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;

public interface ApiService {

	//project
	Long updateProject(ProjectBean projectBean) throws Exception;

	Optional<Iterable<ProjectHIBBean>> readAllProjects() throws Exception;

	Optional<ProjectHIBBean> readProjectById(Long projectId) throws Exception;

	Long createProject(ProjectBean projectBean) throws Exception;

	void deleteProject(ProjectBean projectBean) throws Exception;

	// login
	Long updateLogin(LoginHIBBean loginHIBBean) throws ModulException;

	String readLoginByUsernameAndPassword(String username, String password) throws ModulException;

	Long createAccount(LoginHIBBean loginHIBBean) throws ModulException;
	
	Optional<LoginHIBBean> readLoginById(Long loginId) throws ModulException;
}
