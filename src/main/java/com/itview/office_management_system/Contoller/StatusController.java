package com.itview.office_management_system.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
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
	
//	@PostMapping("/saveDefaultStatus")
//	public ResponseEntity<Integer> saveDefaultStatus(@RequestBody Status statusData)
//	{
//		Status status=service.saveDefaultStatus(statusData);
//		return new ResponseEntity<>(status.getStatusId(),HttpStatus.CREATED);
//		
//	}
	
	@GetMapping("/getById")
	public  ResponseEntity<String> getStatusById(@Nullable @RequestParam String id)
	{
		Status status=service.getStatusById(Integer.valueOf(id));
		return new ResponseEntity<>(status.toString(),HttpStatus.OK);
		
	}
	
	@GetMapping("/statusList")
	public ResponseEntity<String> getAll()
	{
		List<Status> statusAll=service.getAll();
		return new ResponseEntity<>(statusAll.toString(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStatus/{id}")
	public ResponseEntity<String> deleteStatus(@Nullable @PathVariable String id )
	{
		service.deleteStatus(Integer.valueOf(id));
		return new ResponseEntity<>("Done",HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("updateStatus/{id}")
	public ResponseEntity<String> updateStatus(@RequestBody Status statusNew, @PathVariable String id )
	{
		service.updateStatus(statusNew, Integer.valueOf(id));
		return new ResponseEntity<>("Status Updated",HttpStatus.OK);
	}
	
}
