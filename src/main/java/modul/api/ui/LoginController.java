package modul.api.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import modul.api.service.ApiService;
import modul.api.service.bean.LoginBean;
import modul.api.service.bean.RegisterUIBean;
import modul.api.service.exception.ProjectCollectorException;

/**
 * the controller for all views for the login and registration
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.2
 */
@RestController
public class LoginController {

	@Autowired
	ApiService apiService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public LoginBean index(HttpServletRequest request) {
		return new LoginBean();
	}

	@RequestMapping(value = "/project/role/{id}", method = RequestMethod.POST)
	public List<LoginBean> showRoleChanger(@AuthenticationPrincipal LoginBean loginBean, HttpServletRequest request) throws ProjectCollectorException {
		List<LoginBean> list = new ArrayList<>();
		apiService.readAllLogin().get().forEach(hib -> list.add(new LoginBean(hib.getUsername(), hib.getPassword())));
		return list;
	}

	@RequestMapping(value = "/project/role/submit/{id}", method = RequestMethod.PUT)
	public LoginBean changeRoles(@RequestParam("role") String role, @AuthenticationPrincipal LoginBean userToChange, HttpServletRequest request) {
		return new LoginBean(userToChange.getUsername(), userToChange.getPassword(), 
				userToChange.getLoginId(), userToChange.getRole());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RegisterUIBean register(HttpServletRequest request) {
		return new RegisterUIBean();
	}

	@RequestMapping(value = "/login/check/{id}", method = RequestMethod.POST)
	public LoginBean loginCheck(@AuthenticationPrincipal LoginBean loginBean, HttpServletRequest request) throws Exception {
		return new LoginBean(loginBean.getUsername(), loginBean.getPassword());
	}

	@RequestMapping(value = "/register/submit", method = RequestMethod.POST)
	public RegisterUIBean registrationProcess(@AuthenticationPrincipal RegisterUIBean registerUIBean) {
		return new RegisterUIBean(registerUIBean.getName(), registerUIBean.getLastname(), registerUIBean.getUsername(), registerUIBean.getPassword(), registerUIBean.getConfirmPassword(), registerUIBean.getEmail(), registerUIBean.getRole());
	}
}
