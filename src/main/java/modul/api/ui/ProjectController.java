package modul.api.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import modul.api.service.ApiService;
import modul.api.service.bean.ProjectBean;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.TeamHIBBean;

/**
 * the controller for all views for the project
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
@RestController
public class ProjectController {

	@Autowired
	private ApiService service;

	@RequestMapping(value = "/projectUser", method = RequestMethod.GET)
	public ProjectBean showOverviewUser(HttpServletRequest request) {
		return new ProjectBean();
	}

	@RequestMapping(value = "/projectOverview/", method = RequestMethod.POST)
	public List<ProjectBean> user(HttpServletRequest request) throws ProjectCollectorException {
		List<ProjectBean> list = new ArrayList<>();
		service.readAllProjects().get()
				.forEach(hib -> list.add(new ProjectBean(hib.getProjectId(), hib.getProjectName(), hib.getReleaseDate(),
						hib.getDescription(), hib.getTeam().getTeamId().toString())));
		return list;
	}

	@RequestMapping(value = "/projectAdmin/{id}", method = RequestMethod.POST)
	public ProjectBean showOverviewAdmin(HttpServletRequest request) {
		return new ProjectBean();
	}

	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	public ModelAndView admin(HttpServletRequest request) throws ProjectCollectorException {
		List<ProjectBean> list = new ArrayList<>();
		service.readAllProjects().get().forEach(hib -> list.add(new ProjectBean(hib.getProjectId(),
				hib.getProjectName(), hib.getReleaseDate(), hib.getDescription(), null)));
		return new ModelAndView("/project/overviewProjectAdmin");
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public List<TeamHIBBean> displayCreateProjectForm(@AuthenticationPrincipal ProjectBean projectBean, HttpServletRequest request) throws ProjectCollectorException {
		return (List<TeamHIBBean>) service.readAllTeams().get();
	}

	@RequestMapping(value = "/project/add/{id}", method = RequestMethod.PUT)
	public ProjectBean saveProject(@AuthenticationPrincipal ProjectBean projectBean, HttpServletRequest request) {
		return new ProjectBean(projectBean.getProjectName(), projectBean.getReleaseDate(), projectBean.getDescription(), projectBean.getDeveloperteam());
	}

	@RequestMapping(value = "/project/update/{id}", method = RequestMethod.PUT)
	public ProjectBean updateProject(@AuthenticationPrincipal ProjectBean projectBean, HttpServletRequest request) {
		return new ProjectBean(projectBean.getProjectId(), projectBean.getProjectName(), projectBean.getReleaseDate(), projectBean.getDescription(), projectBean.getDeveloperteam());
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
	public ProjectBean removeProject(@PathVariable Long id, HttpServletRequest request) {
		return new ProjectBean(id);
	}

}
