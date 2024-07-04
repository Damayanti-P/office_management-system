package com.itview.office_management_system.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itview.office_management_system.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

//	public List<Employee> getEmployees();

	Employee findByUsername(String username);

	

}
