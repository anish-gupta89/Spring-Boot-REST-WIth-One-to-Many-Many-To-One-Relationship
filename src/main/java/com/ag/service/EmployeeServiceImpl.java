package com.ag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ag.binding.EmployeeModel;
import com.ag.db.DepartmentEntity;
import com.ag.db.DepartmentRepo;
import com.ag.db.EmployeeEntity;
import com.ag.db.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	DepartmentRepo departRepo;
	
	@Override
	public EmployeeModel saveEmp(EmployeeModel employeeModel) {
		EmployeeEntity empEntity =  new EmployeeEntity();
		BeanUtils.copyProperties(employeeModel, empEntity);
		EmployeeEntity savedEmp = empRepo.save(empEntity);
		
		employeeModel.getDepartmentName().forEach(department->{
			DepartmentEntity departmentEntity =  new DepartmentEntity();
			departmentEntity.setDeptName(department);
			departmentEntity.setEmployee(savedEmp);
			departRepo.save(departmentEntity);
		});
		
		
		BeanUtils.copyProperties(savedEmp, employeeModel);
		return employeeModel;
	}

	@Override
	public List<EmployeeModel> getAllEmployee() {
		Iterable<EmployeeEntity> allEmp = empRepo.findAll();
		List<EmployeeModel> empList = new ArrayList<EmployeeModel>();
		allEmp.forEach(data->{
			List<String> dapartmentData =  new ArrayList<>();
			data.getDepartment().forEach(depart->{
				String deptName = depart.getDeptName();
				dapartmentData.add(deptName);
			});
			EmployeeModel employeeModel =  new EmployeeModel();
			employeeModel.setDepartmentName(dapartmentData);
			BeanUtils.copyProperties(data, employeeModel);
			empList.add(employeeModel);
		});
		return empList;
	}

}
