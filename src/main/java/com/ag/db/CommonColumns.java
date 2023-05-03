package com.ag.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@MappedSuperclass
@Data
public class CommonColumns {

	@CreationTimestamp
	@Column(updatable = false, name = "CREATED_DATE")
	Date createdDate;
	
	@UpdateTimestamp
	@Column(updatable = true, name = "UPDATED_DATE")
	Date updatedDate;

}
