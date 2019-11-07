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
import modul.api.service.hibbean.ProjectHIBBean;

@Controller
public class LoginController {
	
	@Autowired
	ApiService apiService;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value="/login")
	public String index(@Valid@ModelAttribute("login")LoginBean loginBean, BindingResult result){
		return "/login/viewLogin";
	}
	
	@RequestMapping(value="/register")
	public String register(@Valid@ModelAttribute("register")RegisterUIBean regiterUIBean, BindingResult result) {
		return "/login/viewRegister";
	}
	
	@RequestMapping(value="/login/check")
	public ModelAndView loginCheck(@Valid@ModelAttribute("login")LoginBean loginBean, BindingResult result, ModelMap model) throws Exception {
		result.getAllErrors();
		try {
			String role = apiService.readLoginByUsernameAndPassword(loginBean.getUsername(), loginBean.getPassword());
			if(role.isEmpty() || Objects.isNull(role)) {
				model.addAttribute("error", "Username or password is not correct!");
				return new ModelAndView("/login/viewLogin");
			}else if(role.equals("AD")) {
				model.addAttribute("success", "Du bist admin");
				model.addAttribute("projects", (List<ProjectHIBBean>) apiService.readAllProjects().get());
				return new ModelAndView("/project/overviewProjectAdmin");
			}
			model.addAttribute("success", "Du bist user");
			return new ModelAndView("/project/overviewProject");
		} catch (ModulException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView();
	}
	
	//TODO: Bitte name vo de Methode aendere
	@RequestMapping(value="/register/check")
	public ModelAndView verarbeiteRegistrierung(@Valid@ModelAttribute("register")RegisterUIBean registerUIBean, BindingResult result) {
		return new ModelAndView();
	}
}
