package com.ag.service;

import java.util.List;

import com.ag.binding.EmployeeModel;

public interface EmployeeService {
	
	EmployeeModel saveEmp(EmployeeModel employeeModel);
	
	List<EmployeeModel> getAllEmployee();
}
