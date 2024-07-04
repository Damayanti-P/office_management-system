package com.itview.office_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="status_table")
public class Status 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int statusId;
	
	@Column(name = "empName")
	private String statusName;
	
	@Column(name = "status")
	private String statusDes;
}
