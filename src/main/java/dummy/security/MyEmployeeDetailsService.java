package dummy.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dummy.entity.EmployeeEntity;
import dummy.model.EmployeeModel;
import dummy.repository.EmployeeRepository;

@Service
public class MyEmployeeDetailsService implements UserDetailsService {

	
	EmployeeEntity emp;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	EmployeeModel empModel;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EmployeeEntity entity = empRepo.findByUsername(username);
		
		if (entity == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(entity.getUsername(), entity.getPassword(),
				new ArrayList<>());
	}
	
	public EmployeeEntity save(EmployeeModel user) {
		EmployeeEntity newUser = new EmployeeEntity();
		emp.setUsername(user.getUsername());
		emp.setPassword(bcryptEncoder.encode(user.getPassword1()));
		return empRepo.save(newUser);
	}

}
