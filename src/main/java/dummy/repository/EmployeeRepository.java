package dummy.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dummy.entity.CompositeEmployeeId;
import dummy.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, CompositeEmployeeId> {

	EmployeeEntity findByUsername(String username);

	EmployeeEntity findByEmail(String email);

	@Modifying(clearAutomatically = true)
	@Query("update EmployeeEntity e set e.firstname = :firstname where e.CompositeEmployeeId.empId= :empId")
	void updateFirstnameByID(@Param("empId")int empId,@Param("firstname")String firstname);

	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select EmployeeEntity e where e.CompositeEmployeeId.empId= :empId")
	void LockByID(@Param("empId")int empId);
	
	List<EmployeeEntity> findAllById(PageRequest of);

	Boolean findByUsernameAndPassword(String username, String password);

	@Query("delete EmployeeEntity e where e.CompositeEmployeeId.empId= :empId")
	void deleteById(@Param("empId")int empId); 
}
