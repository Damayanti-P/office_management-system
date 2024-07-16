package com.itview.office_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itview.office_management_system.entity.Employee;
import com.itview.office_management_system.utils.EncryptDecrypt;

@Service
public class LoginService {
	
	@Autowired
	EmployeeService empService;
	
	
	public Employee login(String username, String password) 
	{
		
		Employee emp=empService.getEmployeeByUsername(username);
		String encryptedPass=EncryptDecrypt.encrypt(username, password);
		if(emp.getPassword().equals(encryptedPass))
		{
			return emp	;
		}
		return null;
		
	}

}
