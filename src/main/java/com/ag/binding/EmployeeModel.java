package com.ag.binding;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EmployeeModel {

	Integer empId;
	String empName;
	BigInteger empSalary;
	String cityName;
	Date createdDate;
	Date updatedDate;
	List<String> departmentName;
	
}
