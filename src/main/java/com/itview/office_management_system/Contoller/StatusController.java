package com.itview.office_management_system.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.itview.office_management_system.Service.StatusService;
import com.itview.office_management_system.entity.Employee;
import com.itview.office_management_system.entity.Status;

@RestController
@RequestMapping("/status")
public class StatusController 
{
	@Autowired
	StatusService service;
	
	@PostMapping("/status")
	public ResponseEntity<Integer> saveStatus(@RequestBody Status statusData)
	{
		Status status=service.saveStatus(statusData);
		return new ResponseEntity<>(status.getStatusId(),HttpStatus.CREATED);
		
	}
}
