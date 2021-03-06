package dummy.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.hibernate.boot.spi.JpaOrmXmlPersistenceUnitDefaultAware;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dummy.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, JpaOrmXmlPersistenceUnitDefaultAware {
	
	List<EmployeeEntity> findAll();

	EmployeeEntity findByUsername(String username);

	EmployeeEntity findByEmail(String email);

	@Modifying(clearAutomatically = true)
	@Query(value="update EMPLOYEE_TABLE e set e.FIRST_NAME = :firstname where e.EMP_ID= :empId",nativeQuery = true)
	void updateFirstnameByID(@Param("empId")int empId,@Param("firstname")String firstname);

	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select EmployeeEntity e where e.empId= :empId")
	void LockByID(@Param("empId")int empId);
	
	List<EmployeeEntity> findAllById(PageRequest of);

	Boolean findByUsernameAndPassword(String username, String password); 
}
