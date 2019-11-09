package modul.api.ui;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import modul.api.service.ApiService;
import modul.api.service.bean.ProjectBean;

@Controller
public class ProjectController {

	@Autowired
	private ApiService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	@RequestMapping(value="/projectUser")
	public ModelAndView showOverviewUser() {
		return new ModelAndView("redirect:/projectOverview");
	}
	
	@RequestMapping(value="/projectOverview")
	public ModelAndView user() {
		LOGGER.info("return page for an user");
		return new ModelAndView("/project/overviewProject");
	}

	@RequestMapping(value ="/projectAdmin")
	public ModelAndView showOverviewAdmin() {
		LOGGER.info("return page for an admin");
		return new ModelAndView("redirect:/projects");
	}
	
	@RequestMapping(value ="/projects")
	public ModelAndView admin() {
		return new ModelAndView("/project/overviewProjectAdmin");
	}
	
	@RequestMapping(value = "/project")
	public ModelAndView displayCreateProjectForm(@Valid @ModelAttribute("project") ProjectBean projectBean,
			BindingResult result, ModelMap model) {
		return new ModelAndView("/project/viewCreateProject");
	}

	@RequestMapping(value = "/project/add")
	public ModelAndView saveComponent(@Valid @ModelAttribute("project") ProjectBean projectBean, BindingResult result,
			ModelMap model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("errors", result.getAllErrors());
				LOGGER.error("Validation error: " + result.getAllErrors());
			} else if (projectBean.getProjectId() != null) {
				updateProject(projectBean);
				model.addAttribute("success", "Das Projekt wurde erfolgreich aktualisiert!");
				LOGGER.info("Project was successfully updated!");
			} else {
				createProject(projectBean);
				model.addAttribute("success", "Das Projekt wurde erfolgreich erstellt!");
				LOGGER.info("Project was successfully created!");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("/project/viewCreateProject");
	}

	private void updateProject(ProjectBean projectBean) throws Exception {
		service.updateProject(projectBean);
	}

	private void createProject(ProjectBean projectBean) throws Exception {
		service.createProject(projectBean);
	}
}
