package modul.api.ui;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import modul.api.service.ApiService;
import modul.api.service.bean.ProjectBean;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.ProjectHIBBean;
import modul.api.service.hibbean.TeamHIBBean;

/**
 * the controller for all views for the project
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
@Controller
public class ProjectController {

	@Autowired
	private ApiService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	@RequestMapping(value = "/projectUser")
	public ModelAndView showOverviewUser() {
		return new ModelAndView("redirect:/projectOverview");
	}

	@RequestMapping(value = "/projectOverview")
	public ModelAndView user(ModelMap model) {
		try {
			model.addAttribute("projects", (List<ProjectHIBBean>) service.readAllProjects().get());
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info("return page for an user");
		return new ModelAndView("/project/overviewProject");
	}

	@RequestMapping(value = "/projectAdmin")
	public ModelAndView showOverviewAdmin() {
		LOGGER.info("return page for an admin");
		return new ModelAndView("redirect:/projects");
	}

	@RequestMapping(value = "/projects")
	public ModelAndView admin(ModelMap model) {
		try {
			model.addAttribute("projects", (List<ProjectHIBBean>) service.readAllProjects().get());
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("/project/overviewProjectAdmin");
	}

	@RequestMapping(value = "/projekt")
	public ModelAndView displayCreateProjectForm(@Valid @ModelAttribute("project") ProjectBean projectBean,
			BindingResult result, ModelMap model) {
		try {
			model.addAttribute("developerteam", (List<TeamHIBBean>) service.readAllTeams().get());
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage());
		}
		return new ModelAndView("/project/viewCreateProject");
	}
	
	@RequestMapping(value = "/project/add")
	public ModelAndView saveProject(@Valid @ModelAttribute("project") ProjectBean projectBean, BindingResult result,
			ModelMap model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("errors", result.getAllErrors());
				model.addAttribute("developerteam", (List<TeamHIBBean>) service.readAllTeams().get());
				LOGGER.error("Validation error: " + result.getAllErrors());
			} else if (projectBean.getProjectId() != null) {
				updateProject(projectBean);
				model.addAttribute("success", "Das Projekt wurde erfolgreich aktualisiert!");
				LOGGER.info("Project was successfully updated!");
			} else {
				createProject(projectBean);
				model.addAttribute("success", "Das Projekt wurde erfolgreich erstellt!");
				model.addAttribute("projectName", "");
				model.addAttribute("description", "");
				LOGGER.info("Project was successfully created!");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("/project/viewCreateProject");
	}

	@RequestMapping(value = "/project/update")
	public ModelAndView updateProject(@Valid  @ModelAttribute("project") ProjectBean projectBean, BindingResult result,
			ModelMap model) {
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/project/{id}")
	public ModelAndView removeProject(@PathVariable Long id) {
		return new ModelAndView();
	}
	
	
	private void updateProject(ProjectBean projectBean) throws Exception {
		service.updateProject(projectBean);
	}

	private void createProject(ProjectBean projectBean) throws Exception {
		service.createProject(projectBean);
	}
}
