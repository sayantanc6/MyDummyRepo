package dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dummy.model.EmployeeLoginModel;
import dummy.service.EmployeeServiceImpl;

@RestController
public class LoginController {
	
	//empServic
	@Autowired
	EmployeeServiceImpl empService;
	
	int requestHit =0;
	int tryouts = 3; 
	
	@RequestMapping(value="Login",headers="Accept=application/json",method=RequestMethod.POST)
	public ModelAndView LoginEmployee(@RequestBody EmployeeLoginModel model, ModelMap map) {
		requestHit++;
		if(requestHit == 1) {
			if (!empService.usernameExists(model.getUsername(), model.getPassword())) {
				map.addAttribute("tryouts", tryouts); 
				map.addAttribute("newUser", true);
				return new ModelAndView("Login", map); 
			}else { 
				model.setAccounLock(false);
				return new ModelAndView("EmployeeView", map);
			}
		}else {
			if (!empService.usernameExists(model.getUsername(), model.getPassword())) {
				tryouts--;
				map.addAttribute("tryouts", tryouts);
				map.addAttribute("newUser", true);
				return new ModelAndView("Login", map);
			}else if(tryouts == 0){
				model.setAccounLock(true);
				return new ModelAndView("badUser", map);
			}else {
				model.setAccounLock(false);
				return new ModelAndView("EmployeeView", map); 
			}
		} 
	}
}
