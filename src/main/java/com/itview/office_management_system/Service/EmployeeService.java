package com.itview.office_management_system.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itview.office_management_system.DAO.EmployeeRepo;
import com.itview.office_management_system.DAO.StatusRepo;
import com.itview.office_management_system.entity.Employee;
import com.itview.office_management_system.entity.Status;
import com.itview.office_management_system.utils.EncryptDecrypt;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	

	@Autowired
	StatusRepo statusrepo;
	
	public Employee saveEmploye(Employee empData) {
		String encodedePass=EncryptDecrypt.encrypt(empData.getUsername(), empData.getPassword());
		empData.setPassword(encodedePass);
		Status status=statusrepo.findById(1).get();
		empData.setStatus(status);
		Employee employee=repo.save(empData);
		return employee;
	}

	public Employee getEmployeesById(Integer empId){
		Employee emp=repo.findById(empId).get();
		Status status=emp.getStatus();
		if(status.getStatusId()==1)
		{
			return emp;
		}
		return new Employee();
	}
	public List<Employee> getEmployees()
	{
		
		List<Employee> emp=repo.getEmployees();
		List<Employee> allEmp=new ArrayList<>();
		for(Employee activeEmployee: emp)
		{
			Status status=activeEmployee.getStatus();
			if(status.getStatusId()==1)
			{
				allEmp.add(activeEmployee);
			}
		}
		return allEmp;
	}

	public Employee getEmployeeByUsername(String username)
	{
		
		Employee emp=repo.findByUsername(username);
		Status status=emp.getStatus();
		if(status.getStatusId()==1)
		{
		return emp;
		}
		return new Employee();
	}
	

	public void deleteEmployeeById(Integer empId) {
		Status status=statusrepo.findById(2).get();
		Employee empDelete= getEmployeesById(empId);
		empDelete.setStatus(status);
		repo.save(empDelete);
	}

	
	public void updateEmployee(Employee empData,Integer empId) {
			Employee emp=repo.findById(empId).get();
			empData.setEmpId(emp.getEmpId());
			saveEmploye(empData);
	}

	
}