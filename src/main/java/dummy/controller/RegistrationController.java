package dummy.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dummy.model.EmployeeModel;
import dummy.security.OnRegistrationCompleteEvent;
import dummy.security.VerificationToken;
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
	
	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
	public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {
	  
	    Locale locale = request.getLocale();
	     
	    VerificationToken verificationToken = empService.getVerificationToken(token);
	    if (verificationToken == null) {
	        String message = messages.getMessage("auth.message.invalidToken", null, locale);
	        model.addAttribute("message", message);
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    }
	     
	    user = verificationToken.getUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        String messageValue = messages.getMessage("auth.message.expired", null, locale);
	        model.addAttribute("message", messageValue);
	        return "redirect:/WEB-INF/views/badUser.jsp?lang=" + locale.getLanguage();
	    } 
	     
	    ((EmployeeModel) model).setEnabled(true); 
	    empService.saveRegisteredUser((EmployeeModel) model); 
	    return "redirect:/login.html?lang=" + request.getLocale().getLanguage(); 
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
