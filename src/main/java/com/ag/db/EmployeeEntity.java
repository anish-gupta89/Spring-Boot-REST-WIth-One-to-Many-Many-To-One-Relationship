package com.ag.db;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_EMP")
@Setter
@Getter
public class EmployeeEntity extends CommonColumns{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	private BigInteger empSalary;
	private String cityName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee" )
	private List<DepartmentEntity> department;
	
	
	
}
