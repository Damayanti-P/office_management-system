package com.itview.office_management_system.Contoller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.itview.office_management_system.Service.EmployeeService;
import com.itview.office_management_system.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService service;
	
	@PostMapping("/employee")
	public ResponseEntity<Integer> saveEmployee(@RequestBody Employee empData)
	{
		service.saveEmploye(empData);
		return new ResponseEntity<>(empData.getEmpId(),HttpStatus.CREATED);
		
	}
	
//	@GetMapping("/data")
//	public ResponseEntity<String> getEmployees( )
//	{
//		List<Employee> emp= service.getEmployees();
//		return new ResponseEntity<>(emp.toString(),HttpStatus.OK);
//		
//	}
	
	@GetMapping("/dataById")
	public ResponseEntity<String> getEmployeesbyId(@Nullable @RequestParam String empId )
	{
		Employee emp= service.getEmployeesById(Integer.valueOf(empId));
		return new ResponseEntity<>(emp.toString(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getByUsername")
	public ResponseEntity<String> getEmployeeByUsername(@Nullable @RequestParam String username)
	{
		Employee emp=service.getEmployeeByUsername(username);
		return new ResponseEntity<>(emp.toString(),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{empId}")
	public  ResponseEntity<String> deleteEmployeeById(@PathVariable String empId)
	{
		service.deleteEmployeeById(Integer.valueOf(empId));
		return new ResponseEntity<>("Done",HttpStatus.OK);
	}
	
	
	@PutMapping("update/{empId}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee empData,@PathVariable String empId)
	{
		service.updateEmployee(empData,Integer.valueOf(empId));
		return new ResponseEntity<>("Employee Updated",HttpStatus.OK);
	}
}
