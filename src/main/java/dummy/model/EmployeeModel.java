package dummy.model;

import java.util.Arrays;

import org.dozer.Mapping;
import org.springframework.stereotype.Component;

@Component("modelEmployee")
public class EmployeeModel {
    private int empid;
    private boolean enabled;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password1;
	private String password2;
	private byte[] photo;
	
	
	
	public EmployeeModel(int empid, boolean enabled, String username, String firstname, String lastname, String email,
			String password1, String password2, byte[] photo) {
		super();
		this.empid = empid;
		this.enabled = enabled;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password1 = password1;
		this.password2 = password2;
		this.photo = photo;
	}

	@Mapping("EmpID")
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	@Mapping("firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Mapping("lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Mapping("email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Mapping("username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Mapping("password")
	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	@Mapping("password")
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Mapping("photo")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] profilephoto) {
		this.photo = profilephoto;
	}

	@Override
	public String toString() {
		return "EmployeeModel [empid=" + empid + ", enabled=" + enabled + ", username=" + username + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", password1=" + password1
				+ ", password2=" + password2 + ", photo=" + Arrays.toString(photo) + "]";
	}

	


}
