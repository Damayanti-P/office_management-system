package com.itview.office_management_system.Contoller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itview.office_management_system.Service.LoginService;
import com.itview.office_management_system.entity.Employee;

@RestController
public class LoginController
{
	@Autowired
	LoginService lservice;
	
	public ResponseEntity<String> login(@RequestBody String credentials )
	{
		JSONObject jsonCred=new JSONObject(credentials);
		String username=jsonCred.getString("username");
		String password=jsonCred.getString("password");
		
		String token=lservice.login(username,password);
		if(null==token)
		{
			return new ResponseEntity<>("Username or password not valid",HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(token.toString(),HttpStatus.BAD_REQUEST);
		
	}
	
}
