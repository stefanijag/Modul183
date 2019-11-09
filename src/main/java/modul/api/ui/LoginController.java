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
import org.springframework.web.servlet.ModelAndView;

import modul.api.service.ApiService;
import modul.api.service.bean.LoginBean;
import modul.api.service.bean.RegisterUIBean;
import modul.api.service.exception.ModulException;
import modul.api.service.hibbean.LoginHIBBean;
import modul.api.service.hibbean.ProjectHIBBean;

@Controller
public class LoginController {

	@Autowired
	ApiService apiService;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public String index(@Valid @ModelAttribute("login") LoginBean loginBean, BindingResult result) {
		return "/login/viewLogin";
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
				model.addAttribute("error", "Username or password is not correct!");
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
		} catch (ModulException e) {
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
		} catch (ModulException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("/login/viewRegister");
	}
}
