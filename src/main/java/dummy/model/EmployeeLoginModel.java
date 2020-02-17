package dummy.model;

import org.springframework.stereotype.Component;

@Component("loginModel")
public class EmployeeLoginModel {
	 
	private String username;
	private String password;
	private Boolean accounLock;
	public EmployeeLoginModel(String username, String password, Boolean accounLock) {
		super();
		this.username = username;
		this.password = password;
		this.accounLock = accounLock;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAccounLock() {
		return accounLock;
	}
	public void setAccounLock(Boolean accounLock) {
		this.accounLock = accounLock;
	}
	
	



}
