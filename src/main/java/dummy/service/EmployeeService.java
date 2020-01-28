package dummy.service;

import java.util.List;

import dummy.model.EmployeeModel;

public interface EmployeeService {
	public void LockByID(int empId);
	public List<EmployeeModel> getAll();
	public void update(int empId, String firstname);
	public void insert(EmployeeModel employee);
	public int delete(int empId);
	public boolean findEmail(String email);
	public boolean UsernameExists(String username);
	List<EmployeeModel> getEmployees(int pageCount, int size);
	public Boolean usernameExists(String username, String Password);

}
