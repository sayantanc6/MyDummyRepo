package dummy.security;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationEvent;

import dummy.model.EmployeeModel;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
	
	

	private static final long serialVersionUID = 1161598696604879344L;
	
	private HttpServletRequest request;
	private String appUrl;
     private Locale locale;
     private EmployeeModel emp;

	public OnRegistrationCompleteEvent(  HttpServletRequest request, EmployeeModel emp,Locale locale, String appUrl) {
		super(emp);
		this.appUrl = appUrl;
		this.locale = locale;
		this.emp = emp;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public EmployeeModel getEmp() {
		return emp;
	}

	public void setEmp(EmployeeModel emp) {
		this.emp = emp;
	}
}
