package com.ag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ag.binding.EmployeeModel;
import com.ag.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "save")
	public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeModel emp) {
		EmployeeModel savedEmp = employeeService.saveEmp(emp);
		return new ResponseEntity<EmployeeModel>(savedEmp,HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "emp")
	public ResponseEntity<List<EmployeeModel>> getAllEmp() {
		 List<EmployeeModel> allEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<List<EmployeeModel>>(allEmployee,HttpStatus.OK);
	}
	
}
