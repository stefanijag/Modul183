package modul.api.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import modul.api.service.ApiService;
import modul.api.service.bean.LoginBean;
import modul.api.service.exception.ProjectCollectorException;
import modul.api.service.hibbean.LoginHIBBean;

@RestController
public class LoginControllerRest {

	@Autowired
	ApiService apiService;
	
	@GetMapping
    public List<LoginBean> findAll() throws ProjectCollectorException {
		List<LoginBean> beans = new ArrayList<>();
		apiService.readAllLogin().get().forEach(hib -> beans.add(new LoginBean(hib.getUsername(), hib.getPassword())));
        return beans;
    }
	
	@GetMapping(value = "/{id}")
    public LoginBean findById(@PathVariable("id") Long id) throws Exception {
		LoginHIBBean loginHIBBean = apiService.readLoginById(id).get();
		RestPrecondition.checkFound(loginHIBBean);
        return new LoginBean(loginHIBBean.getUsername(), loginHIBBean.getPassword());
    }
	
}
