package dummy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dummy.model.EmployeeModel;
import dummy.security.OnRegistrationCompleteEvent;
import dummy.service.EmployeeServiceImpl;

@RestController
public class RegistrationController {
	 
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired
	@Qualifier("modelEmployee")
	EmployeeModel model;
	
	@Autowired
	DozerBeanMapper mapper;
	
	@Autowired
	User user;
	
	@Autowired 
	private MessageSource messages;
	
	@Autowired
	EmployeeServiceImpl empService;
	
	@RequestMapping("signup")
	public String NewUser() {
		return "Registration";
	}
	
	@RequestMapping(value="register",headers="Accept=application/json",method=RequestMethod.POST)
	@ResponseBody
	public  ModelAndView registerEmployee(@RequestPart("properties") EmployeeModel model,@RequestPart("photo") MultipartFile photo, ModelMap map, WebRequest request,HttpServletRequest req) throws IOException {
		String appUrl = request.getContextPath();
		if (empService.UsernameExists(model.getUsername())) { 
			model.setPhoto(photo.getBytes());			
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent
			          (req,model, request.getLocale(), appUrl));
		}
		empService.insert(model);
		return new ModelAndView("EmployeeView", "employee", model);
		
	}

}
