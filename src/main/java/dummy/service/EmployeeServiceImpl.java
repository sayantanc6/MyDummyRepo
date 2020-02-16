package dummy.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dummy.entity.CompositeEmployeeId;
import dummy.entity.EmployeeEntity;
import dummy.entity.VerificationToken;
import dummy.model.EmployeeModel;
import dummy.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	DozerBeanMapper mapper;
	
	@Autowired
	@Qualifier("modelEmployee")
	EmployeeModel model;
	
	List<EmployeeModel>  employeeModels;
	
	EmployeeEntity emp;
    CompositeEmployeeId empId;


	@Override
	public List<EmployeeModel> getAll() {
		employeeModels.clear();
		empRepo.findAll().forEach(emp -> {
			employeeModels.add(mapper.map(emp, EmployeeModel.class)); 
			});  
		return employeeModels;

	} 

	@Override
	public void update(int empId, String firstname) {
		empRepo.updateFirstnameByID(empId,firstname);
	}

	@Override
	public void insert(EmployeeModel model) {
		empRepo.saveAndFlush(mapper.map(model, EmployeeEntity.class));
	}

	@Override
	public int delete(int empId) {
		empRepo.deleteById(empId);
		return 1; 
	}

	@Override
	public boolean findEmail(String email) {
		EmployeeEntity entity = empRepo.findByEmail(email);
		if(entity != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean UsernameExists(String username) {
		EmployeeEntity entity = empRepo.findByUsername(username); 
		if(entity != null)
			return true;
		else
			return false;
	}

	@Override
	public void LockByID(int empId) {
		empRepo.LockByID(empId);
	}

	public void saveRegisteredUser(EmployeeModel model) {

		empRepo.saveAndFlush(mapper.map(model, EmployeeEntity.class));
	}

	@Override
	public List<EmployeeModel> getEmployees(int pageCount, int size) {
		employeeModels.clear();
		List<EmployeeEntity> employees = empRepo.findAllById(PageRequest.of(pageCount, size));
		employees.forEach(emp -> {
				employeeModels.add(mapper.map(emp, EmployeeModel.class)); 
				});
		return employeeModels;
	}

	@Override
	public Boolean usernameExists(String username, String Password) {
		return (empRepo.findByUsernameAndPassword(username,Password)!= null)?  true : false;
	}

}
