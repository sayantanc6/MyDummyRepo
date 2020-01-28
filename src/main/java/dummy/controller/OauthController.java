package dummy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {
	
	 @RequestMapping("/")
	    public String login() {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        System.out.println(auth.getPrincipal());
	        return "Login";
	    }
	    
	    @RequestMapping("/callback")
	    public String callback() {
	        System.out.println("redirecting to home page");
	        return "homepage";
	    }

}
