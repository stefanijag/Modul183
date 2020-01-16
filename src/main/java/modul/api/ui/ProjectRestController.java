package modul.api.ui;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import modul.api.service.ApiService;
import modul.api.service.bean.ProjectBean;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.ProjectHIBBean;

/**
 * the controller for all views for the project
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
@RestController
public class ProjectRestController {

	@Autowired
	private ApiService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRestController.class);

	@PostMapping(value = "/projectUser")
	public ModelAndView showOverviewUser() {
		return new ModelAndView("redirect:/projectOverview");
	}

//	@PostMapping(value = "/projectOverview")
	@GetMapping(value = "/projectOverview")
	public ModelAndView user(ModelMap model) {
		try {
			model.addAttribute("projects", (List<ProjectHIBBean>) service.readAllProjects().get());
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info("return page for an user");
		return new ModelAndView("/project/overviewProject");
	}

	@GetMapping(value = "/projectAdmin")
	public ModelAndView showOverviewAdmin() {
		LOGGER.info("return page for an admin");
		return new ModelAndView("redirect:/projects");
	}

	@GetMapping(value = "/projects")
	public ModelAndView admin(ModelMap model) {
		try {
			model.addAttribute("projects", (List<ProjectHIBBean>) service.readAllProjects().get());
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("/project/overviewProjectAdmin");
	}

	@GetMapping(value = "/project")
	public ModelAndView displayCreateProjectForm(@Valid @ModelAttribute("project") ProjectBean projectBean,
			BindingResult result, ModelMap model) {
		List<ProjectHIBBean> list = new ArrayList<>();
//		model.addAttribute("developerteam", list);
//		(List<ProjectHIBBean>) service.readAllProjects().get()
		return new ModelAndView("/project/viewCreateProject");
	}

	@PostMapping(value = "/project")
	public Long saveProject(@Valid @RequestBody ProjectBean projectBean,
			ModelMap model) {
		try {
//			if (result.hasErrors()) {
//				model.addAttribute("errors", result.getAllErrors());
//				LOGGER.error("Validation error: " + result.getAllErrors());
			if (projectBean.getProjectId() != null) {
				return updateProject(projectBean);
//				model.addAttribute("success", "Das Projekt wurde erfolgreich aktualisiert!");
//				LOGGER.info("Project was successfully updated!");
			} else {
				model.addAttribute("success", "Das Projekt wurde erfolgreich erstellt!");
				return createProject(projectBean);
//				LOGGER.info("Project was sucOcessfully created!");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return 0L;
	}

	@PutMapping(value = "/project/update")
	public ModelAndView updateProject(@Valid  @RequestBody ProjectBean projectBean, BindingResult result,
			ModelMap model) {
		return new ModelAndView();
	}
	
	@DeleteMapping(value = "/project/{id}")
	public ModelAndView removeProject(@PathVariable Long id) {
		return new ModelAndView();
	}
	
	
	private Long updateProject(ProjectBean projectBean) throws Exception {
		return service.updateProject(projectBean);
	}

	private Long createProject(ProjectBean projectBean) throws Exception {
		return service.createProject(projectBean);
	}
}
