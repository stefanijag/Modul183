package modul.api.ui;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modul.api.service.ApiService;
import modul.api.service.bean.LoginBean;
import modul.api.service.bean.RegisterUIBean;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;

/**
 * the controller for all views for the login and registration
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
@Controller
public class LoginController {

	@Autowired
	ApiService apiService;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public String index(@Valid @ModelAttribute("login") LoginBean loginBean, BindingResult result) {
		return "/login/viewLogin";
	}

	@RequestMapping(value = "/project/role")
	public ModelAndView showRoleChanger(@Valid @ModelAttribute("login") LoginBean loginBean, BindingResult result,
			ModelMap model) {
		try {
			model.addAttribute("usernames", (List<LoginHIBBean>) apiService.readAllLogin().get());
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("/login/viewAdminChangeRoles");
	}

	@RequestMapping(value = "/project/role/submit")
	public String changeRoles(@RequestParam("role") String role, @Valid @ModelAttribute("login") LoginBean userToChange,
			BindingResult result, ModelMap model) {
		LoginHIBBean loginHIBBean = new LoginHIBBean(userToChange.getLoginId(), role);
		try {
			apiService.updateLogin(loginHIBBean);
			LOGGER.info("Update of Role Change was successfull");
			model.addAttribute("usernames", (List<LoginHIBBean>) apiService.readAllLogin().get());
			model.addAttribute("success", "Role konnte erfolgreich geändert werden!");
		} catch (ProjectCollectorException e) {
			model.addAttribute("error", "Role konnte nicht geändert werden!");
			LOGGER.error(e.getMessage(), e);
		}
		return "/login/viewAdminChangeRoles";
	}

	@RequestMapping(value = "/register")
	public String register(@Valid @ModelAttribute("register") RegisterUIBean regiterUIBean, BindingResult result) {
		return "/login/viewRegister";
	}

	@RequestMapping(value = "/login/check")
	public ModelAndView loginCheck(@Valid @ModelAttribute("login") LoginBean loginBean, BindingResult result,
			ModelMap model) throws Exception {
		result.getAllErrors();
		try {
			String role = apiService.readLoginByUsernameAndPassword(loginBean.getUsername(), loginBean.getPassword());
			if (role == null || role.isEmpty() || Objects.isNull(role)) {
				model.addAttribute("error", "Username oder Passwort ist nicht korrekt!");
				LOGGER.debug("Wrong Login data username: " + loginBean.getUsername() + " and password: "
						+ loginBean.getPassword());
				return new ModelAndView("/login/viewLogin");
			} else if (role.equals("AD")) {
				model.addAttribute("projects", (List<ProjectHIBBean>) apiService.readAllProjects().get());
				LOGGER.info("Successfully logged in as a admin");
				return new ModelAndView("redirect:/projectAdmin");
			}
			model.addAttribute("projects", (List<ProjectHIBBean>) apiService.readAllProjects().get());
			LOGGER.info("Successfully logged in as a User");
			return new ModelAndView("redirect:/projectUser");
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/register/submit")
	public ModelAndView registrationProcess(@Valid @ModelAttribute("register") RegisterUIBean registerUIBean,
			BindingResult result, ModelMap model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("errors", result.getAllErrors());
				LOGGER.error("Validation error:" + result.getAllErrors());
			} else {
//				if(registerUIBean.getPassword().)
				if (registerUIBean.getPassword().equals(registerUIBean.getConfirmPassword())) {
					apiService.createAccount(new LoginHIBBean(registerUIBean.getUsername(), registerUIBean.getRole(),
							registerUIBean.getPassword(), registerUIBean.getEmail(), registerUIBean.getName(),
							registerUIBean.getLastname()));
					LOGGER.info("Registration was successfully made");
					return new ModelAndView("redirect:/login");
				}else {
					LOGGER.info("Password and confirm password does not match");
					model.addAttribute("error", "Passwort und Passwort bestätigen stimmt nicht überein");
				}
			}
		} catch (ProjectCollectorException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("/login/viewRegister");
	}
	
}
