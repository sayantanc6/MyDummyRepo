package dummy.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_TABLE")
public class EmployeeEntity {   
	
	@EmbeddedId
	private CompositeEmployeeId id;
    
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @Column(name="FIRST_NAME")
    private String firstname;
    
    @Column(name="LAST_NAME")
    private String lastname;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="PASSWORD")
    private String password;
    
    @Lob
    @Column(length = 10000)
    private byte[] photo;

	public EmployeeEntity() {
		super();
        this.enabled=false;
	}

	public EmployeeEntity(CompositeEmployeeId id, boolean enabled, String firstname, String lastname, String email,
			String password, byte[] photo) {
		super();
		this.id = id;
		this.enabled = enabled;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.photo = photo;
	}



	public CompositeEmployeeId getId() {
		return id;
	}

	public void setId(CompositeEmployeeId id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", enabled=" + enabled + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", password=" + password + ", photo=" + Arrays.toString(photo) + "]";
	}
	
	
 }
	