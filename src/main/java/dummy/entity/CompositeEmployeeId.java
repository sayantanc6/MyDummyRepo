package dummy.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class CompositeEmployeeId implements Serializable{
	 

	private static final long serialVersionUID = 1L;

	
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "EMP_ID")
    private int EmpID;
	
	
    @Column(name="USER_NAME")
    private String username;
	
	public CompositeEmployeeId() {
		
	}

	public CompositeEmployeeId(int empID, String username) {
		super();
		EmpID = empID;
		this.username = username;
	}
	
	

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) { 
		if(this==o)
			return true;
		if(!(o instanceof CompositeEmployeeId))
			return false;
		CompositeEmployeeId that = (CompositeEmployeeId) o;
		return Objects.equals(getEmpID(), that.getEmpID()) &&
				Objects.deepEquals(getUsername(), that.getUsername());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getEmpID(),getUsername());
	}
	
	

}
