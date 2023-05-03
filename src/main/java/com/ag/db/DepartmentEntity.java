package com.ag.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "TBL_DEPARTMENT")
public class DepartmentEntity extends CommonColumns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptId;
	private String deptName;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private EmployeeEntity employee;

}
