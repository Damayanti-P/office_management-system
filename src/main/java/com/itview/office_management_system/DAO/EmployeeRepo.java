package com.itview.office_management_system.DAO;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.itview.office_management_system.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	Employee findByUsername(String username);
	
	@Query(value="select * from emp_table" , nativeQuery = true)
	List<Employee> getEmployees();

	

}
