package com.itview.office_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itview.office_management_system.entity.Employee;
import com.itview.office_management_system.utils.EncryptDecrypt;

@Service
public class LoginService {
	
	@Autowired
	EmployeeService empService;
	 	
	@Autowired
	JWTservice jwtService;
	
	public String login(String username, String password) 
	{
		
		Employee emp=empService.getEmployeeByUsername(username);
		if(emp==null)
		{
			return  null;
		}
		else{
		String encryptedPass=EncryptDecrypt.encrypt(username, password);
		if(emp.getPassword().equals(encryptedPass))
			{
				String token=jwtService.generateToke(username,emp.getEmpId() );
				jwtService.validateToken(token);
				return token;
			}
		}
		return null;
		
	}

}
