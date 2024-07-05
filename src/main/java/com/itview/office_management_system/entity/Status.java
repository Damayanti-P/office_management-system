package com.itview.office_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="status_table")
public class Status 
{
	@Id
	@Column(name = "id")
	private int statusId;
	
	@Column(name = "stsName")
	private String statusName;
	
	@Column(name = "stsDes")
	private String statusDes;
}
