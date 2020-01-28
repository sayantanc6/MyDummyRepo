package dummy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dummy.entity.EmployeeEntity;
import dummy.model.EmployeeModel;
import dummy.repository.EmployeeRepository;

@Service
public class MyEmployeeDetailsService implements UserDetailsService {
	
	@Autowired
	EmployeeEntity emp;
	
	@Autowired
	EmployeeRepository empRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		emp = empRepo.findByUsername(username);
		if(emp==null)
			throw new UsernameNotFoundException(username);
		return new MyEmployeeDetails(emp);
			}



	

	public void createVerificationToken(EmployeeModel emp, String token) {	
		
	}

}
