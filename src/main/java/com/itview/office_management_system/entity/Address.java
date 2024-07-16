package com.itview.office_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="address_table")
public class Address
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int address_id;
	
	@ManyToOne	
	@JoinColumn(name = "emp")
	private Employee emp; 
	
	@Column(name = "Line1")
	private String Line1;
	
	@Column(name = "landMark")
	private String landMark;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "State")
	private String State;
	
	@Column(name = "Country")
	private String Country;
	
	@Column(name = "pincode")
	private int pincode;
}
